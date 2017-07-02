package com.example.hui.template.badge.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hui.template.R;
import com.example.hui.template.ioc.util.ViewUtils;
import com.example.hui.template.ioc.view.OnClick;

/**
 * Created by hui on 2016/10/9.
 */
public class BadgeViewTestActivity extends AppCompatActivity{
    //  1.明确这个消息数需要放在哪个View上
    private TextView mTextView;

    private BadgeView mNumberBv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewUtils.inject(this);

        mTextView = (TextView) findViewById(R.id.text_view);
        // 2. new BadgeView
        mNumberBv  = new BadgeView(this);
        mNumberBv.setBadgeCount(12);

        // 2.2.绑定View
        mNumberBv.setTargetView(mTextView);
    }

    @OnClick(R.id.text_view)
    private void textViewClick(){
        /*boolean isShow = mNumberBv.isShowDot();

        if(isShow){
            mNumberBv.hideRedDot();
        }else{
            mNumberBv.showRedDot();
        }*/
    }
}
