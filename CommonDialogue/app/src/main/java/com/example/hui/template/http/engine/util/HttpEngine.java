package com.example.hui.template.http.engine.util;

import java.util.Map;

/**
 * Created by hui on 2016/10/10.
 * 自定义的引擎规范
 */
public interface HttpEngine {
    // post提交  参数  url  自定义回调
    public void post(Map<String,String> params,String url,HttpCallBack httpCallBack);

    // get提交
    public void get(Map<String,String> params,String url,HttpCallBack httpCallBack);
}
