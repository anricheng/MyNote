package com.example.hui.template;

import android.app.Application;

import org.xutils.x;

/**
 * Created by hui on 2016/10/10.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
