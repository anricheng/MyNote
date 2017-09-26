package com.example.hui.template.design.mode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hui.template.R;
import com.example.hui.template.ioc.util.ViewUtils;
import com.example.hui.template.titlebar.CommonTitleBar;

/**
 * Created by hui on 2016/10/9.
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected CommonTitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1.设置布局
        setRootView();

        titleBar = (CommonTitleBar) findViewById(R.id.title_bar);

        // 注解的逻辑代码，功能实现代码  公用的东西   改变状态栏颜色  捕捉异常
        ViewUtils.inject(this);

        initTitle(titleBar);

        // 2.初始化界面
        initView();

        // 3.初始化数据
        initData();
    }

    protected abstract void initTitle(CommonTitleBar titleBar);

    // 3.初始化数据
    protected abstract void initData();

    // 2.初始化界面
    protected abstract void initView();

    // 1.设置布局
    protected abstract void setRootView();


    /**
     * 启动一个Activity
     */
    protected void startActivity(Class<? extends Activity> clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
        // 启动动画
    }

    /**
     * 获取屏幕的宽高  Utils
     * 常用的启动Activity
     * 为了内存的管理 不要把不常用的方法写到这里面 abstract  --> 对象
     */
}
