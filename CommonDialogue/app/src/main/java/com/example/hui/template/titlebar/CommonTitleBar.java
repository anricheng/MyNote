package com.example.hui.template.titlebar;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hui.template.R;

/**
 *  Created by hui on 2016/10/12.
 *
 *  自定义头部 View
 */
public class CommonTitleBar extends RelativeLayout implements View.OnClickListener {

    private Context mContext;

    private TextView mTitleTv;

    private TextView mRightTv;

    public CommonTitleBar(Context context) {
        this(context, null);
    }

    public CommonTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.mContext = context;

        // 1. 代码动态添加
        // addView();

        // 2.直接加载写好的布局   ui_common_titlebar   this : parent
        inflate(context, R.layout.ui_common_titlebar, this);
        // LayoutInflater.from(context).inflate(R.layout.ui_common_titlebar,this);
        // View.inflate(context,R.layout.ui_common_titlebar,null);

        // 3. 开始控制头部标题  ， 返回关闭页面
        // 3.1 返回关闭页面  设置点击事件  findViewById
        // activity -->  findViewById   view.findViewById    布局在哪里  this
        findViewById(R.id.back_return_ll).setOnClickListener(this);


        // 3.2 开始控制头部标题  findViewByID  setText  动态代码设置
        mTitleTv = (TextView) findViewById(R.id.title_tv);
        mRightTv = (TextView) findViewById(R.id.right_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_return_ll:
                // 关闭页面  任何地方上下文都可以转成Activity
                ((Activity)mContext).finish();
                break;
        }
    }

    /**
     * 设置头部标题
     * @param title
     */
    public void setTitle(String title){
        mTitleTv.setText(title);
    }

    /**
     * 设置右边文字
     */
    public void setRight(String right){
        mRightTv.setVisibility(View.VISIBLE);
        mRightTv.setText(right);
    }

    /**
     * 设置右边的点击回调监听
     */
    public void setRightOnClick(OnClickListener listener){
        mRightTv.setOnClickListener(listener);
    }
}
