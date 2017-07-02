package com.example.hui.template.http.engine.util;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by hui on 2016/10/10.
 */
public class OkHttpEngine<T> implements HttpEngine {
    @Override
    public void post(Map<String, String> params, String url, final HttpCallBack httpCallBack) {
        FormEncodingBuilder builder = new FormEncodingBuilder();

        // 添加的参数肯定是从  params 里面解析  遍历Map集合
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> entry = (Map.Entry) iterator.next();
            builder.add(entry.getKey(), entry.getValue());
        }


        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                httpCallBack.onError();
            }

            @Override
            public void onResponse(Response response) throws IOException {// 在子线程里面
                String result = new String(response.body().bytes());

                Log.e("OkHttpEngine", result);
                // 2.GSON解析请求到的数据
                Gson gson = new Gson();

                // 获取泛型的类型
                Type genType = httpCallBack.getClass().getGenericSuperclass();
                Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
                Class<T> typeClass = (Class) params[0];

                // 利用Gson转换类型
                final T resultObj = gson.fromJson(result, typeClass);

                HttpUtils.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 把它弄到主线程中
                        httpCallBack.onSuccess(resultObj);
                    }
                });
            }
        });
    }

    @Override
    public void get(Map<String, String> params, String url, HttpCallBack httpCallBack) {

    }
}
