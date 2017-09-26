package com.example.hui.template.http.engine.util;

/**
 * Created by hui on 2016/10/10.
 */
public abstract class HttpCallBack<T> {
    // 回调   成功和失败  abstract  是为了调用者必须要实现该方法
    public abstract void onError();// 失败的方法

    // 直接解析好的可操作的对象  返回的对象不明确
    public abstract void onSuccess(T result);
}
