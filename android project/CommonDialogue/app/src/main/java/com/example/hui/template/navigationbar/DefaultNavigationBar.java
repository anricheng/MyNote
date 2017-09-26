package com.example.hui.template.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.hui.template.R;

/**
 * description：默认的头部，如果需要自定义可以继承AbsNavigation即可
 *
 * Created by 曾辉 on 2016/6/30 22:35
 * QQ：240336124
 * Email: 240336124@qq.com
 * Version：1.0
 */
public class DefaultNavigationBar extends AbsNavigation<DefaultNavigationBar.Builder.DefaultParams>{

    public DefaultNavigationBar(Builder.DefaultParams P) {
        super(P);
    }

    @Override
    public int bindLayoutId() {
        return R.layout.ui_common_titlebar;
    }

    @Override
    public void applyView() {
        // 绑定头部文字  findViewById setText;
        setText(R.id.title_tv, getParams().title);

        // 绑定右边文字
        setText(R.id.right_tv, getParams().right);

        // 左边返回关闭当前页面
        setOnClickListener(R.id.back_return_ll, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 关闭当前页面
                ((Activity)getParams().context).finish();
            }
        });

        // 绑定右边的监听
        setOnClickListener(R.id.right_tv,getParams().rightClickListener);
    }


    public static class Builder extends AbsNavigation.Builder{
        // 这是需要构建的参数对象
        private DefaultParams P;

        public Builder(Context context, ViewGroup parent) {
            P = new DefaultParams(context,parent);
        }

        @Override
        public AbsNavigation create() {
            return new DefaultNavigationBar(P);
        }

        public DefaultNavigationBar.Builder setTitle(String title) {
            P.title = title;
            return this;
        }

        public DefaultNavigationBar.Builder setRight(String right){
            P.right = right;
            return this;
        }

        /**
         * 设置右边的监听
         */
        public DefaultNavigationBar.Builder setRightClickListener(
                View.OnClickListener rightClickListener){
            P.rightClickListener = rightClickListener;
            return this;
        }


        public static class DefaultParams extends Params{
            public String title;
            public String right;
            public View.OnClickListener rightClickListener;

            public DefaultParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }
}
