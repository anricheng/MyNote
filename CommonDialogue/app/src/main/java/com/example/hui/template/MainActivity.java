package com.example.hui.template;

import android.widget.TextView;
import android.widget.Toast;

import com.example.hui.template.design.mode.BaseActivity;
import com.example.hui.template.design.mode.UserLoginActivity;
import com.example.hui.template.ioc.view.CheckNet;
import com.example.hui.template.ioc.view.OnClick;
import com.example.hui.template.ioc.view.ViewById;
import com.example.hui.template.titlebar.CommonTitleBar;

public class MainActivity extends BaseActivity {

    @ViewById(R.id.text_view)  // 用了注解会影响效率  可以忽略
    private TextView mTextView;

    private int mPage = 1;


    @Override
    protected void initTitle(CommonTitleBar titleBar) {

    }

    @Override
    protected void initData() {
        // 定义了一套规范
    }

    @Override
    protected void initView() {

        // 2.初始化控件
        // 3.初始化数据

        // 4.其他
        mTextView.setText("ViewByID!");
    }

    @Override
    protected void setRootView() {
        // 1.设置布局
        setContentView(R.layout.activity_main);
        // mTextView = (TextView) findViewById(R.id.text_view);   findViewByID
    }


    @OnClick({R.id.text_view})
    private void tvClick(){

        Toast.makeText(this,"ViewById!",Toast.LENGTH_SHORT).show();
        // tv.setText("OnClick!");
    }


    /*@OnClick(R.id.login_bt)
    private void userLogin(){
        // 如果没有网络，应该提示用户无网络，不需要调用后台接口
        if(NetManagerUtil.isOpenNetwork(this)){
            Toast.makeText(this,"用户登录！",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"当前无网络~",Toast.LENGTH_SHORT).show();
        }
    }*/

    @OnClick(R.id.login_bt)
    @CheckNet
    private void userLogin(){
        Toast.makeText(this,"用户登录！",Toast.LENGTH_SHORT).show();
        /*// 跳转到登录页面
        Intent intent = new Intent(this, UserLoginActivity.class);
        startActivity(intent);*/
        startActivity(UserLoginActivity.class);
    }
}
