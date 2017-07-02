package com.example.hui.template.http.engine.util;

import android.util.Log;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by hui on 2016/10/10.
 */
public class XutilsHttpEngine<T> implements HttpEngine {
    @Override
    public void post(Map<String, String> params, String url, final HttpCallBack httpCallBack) {
        //  封装url参数
        RequestParams requestParams = new RequestParams(url);

        // 添加的参数肯定是从  params 里面解析  遍历Map集合
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> entry = (Map.Entry) iterator.next();
            /*Object key = entry.getKey();
            Object val = entry.getValue();*/
            requestParams.addParameter(entry.getKey(),entry.getValue());
        }

        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {// 主线程
                Log.e("XutilsHttpEngine", result);
                // 2.GSON解析请求到的数据
                Gson gson = new Gson();

                // 获取泛型的类型
                Type genType = httpCallBack.getClass().getGenericSuperclass();
                Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
                Class<T> typeClass = (Class) params[0];

                // 利用Gson转换类型
                T resultObj = gson.fromJson(result, typeClass);

                httpCallBack.onSuccess(resultObj);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                httpCallBack.onError();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("XutilsHttpEngine","onCancelled:"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("XutilsHttpEngine","onFinished");
            }
        });
    }

    @Override
    public void get(Map<String, String> params, String url, HttpCallBack httpCallBack) {

    }
}
