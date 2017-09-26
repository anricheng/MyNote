package com.example.hui.template.http.engine.util;

import android.os.Handler;

import java.util.Map;

/**
 * Created by hui on 2016/10/10.
 */
public class HttpUtils implements HttpEngine{

    private HttpEngine mHttpEngine;

    public static Handler handler = new Handler();

    public HttpUtils(){
        // 这里用来切换引擎
        mHttpEngine = new XutilsHttpEngine<>();
    }

    @Override
    public void post(Map<String, String> params, String url, HttpCallBack httpCallBack) {
        mHttpEngine.post(params,url,httpCallBack);
    }

    @Override
    public void get(Map<String, String> params, String url, HttpCallBack httpCallBack) {
        mHttpEngine.get(params, url, httpCallBack);
    }
}
