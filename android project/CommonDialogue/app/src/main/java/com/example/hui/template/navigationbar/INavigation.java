package com.example.hui.template.navigationbar;

/**
 * description： 定义一套导航条的规范
 *
 * Created by 曾辉 on 2016/6/30 22:35
 * QQ：240336124
 * Email: 240336124@qq.com
 * Version：1.0
 */
public interface INavigation {
    // 绑定 NavigationBar de layoutId
    public int bindLayoutId();

    // 创建View  并确定添加到哪里
    public void createAndBindView();

    // 绑定和设置参数  Params
    public void applyView();
}
