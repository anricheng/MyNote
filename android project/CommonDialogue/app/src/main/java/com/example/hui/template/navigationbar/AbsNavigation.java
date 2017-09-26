package com.example.hui.template.navigationbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * description： 用来优化基本代码
 * <p>
 * Created by 曾辉 on 2016/6/30 22:35
 * QQ：240336124
 * Email: 240336124@qq.com
 * Version：1.0
 */
public abstract class AbsNavigation<P extends AbsNavigation.Builder.Params> implements INavigation{

    private P prams;

    private View navigationView;

    public AbsNavigation(P prams){
        this.prams = prams;
        createAndBindView();
    }


    protected P getParams(){
        return prams;
    }

    @Override
    public void createAndBindView() {
        // 1.创建和绑定View
        navigationView = View.inflate(prams.context,bindLayoutId(),null);

        // 2.将创建的navigationView加载到 ViewGroup parent里面
        prams.parent.addView(navigationView,0);// 0 加载到最上面

        // 2.绑定和设置参数
        applyView();
    }


    /**
     * 根据Id找到布局View
     */
    public <T extends View> T findViewById(int viewId){
        return (T) navigationView.findViewById(viewId);
    }

    /**
     * 设置文本
     */
    public void setText(int viewId,String text){
        TextView tv = findViewById(viewId);
        tv.setVisibility(View.VISIBLE);
        tv.setText(text);
    }

    /**
     * 设置监听
     */
    public void setOnClickListener(int viewId,View.OnClickListener listener){
        findViewById(viewId).setOnClickListener(listener);
    }

    /**
     * 为了节省最后代码
     * 具体的某些方法还是需要由我们的子类去实现
     */
    public abstract static class Builder<P extends Builder.Params>{

        // 这个方法必须要由子类实现
        public abstract AbsNavigation create();

        public static class Params{
            public Context context;  // 上下文
            public ViewGroup parent; // 头部添加哪里  父布局

            public Params(Context context,ViewGroup parent){
                this.context = context;
                this.parent = parent;
            }
        }
    }
}
