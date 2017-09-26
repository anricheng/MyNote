package com.example.hui.template.adbanner;

/**
 * 
 * ============================================================
 * 
 * project name : DiDi professor
 * 
 * copyright : ZENG HUI (c) 2014
 * 
 * author : HUI
 * 
 * email : 240336124@QQ.com
 * 
 * version : 1.0
 * 
 * date created : On February 14, 2015 13:32:31
 * 
 * description : 自定义导航条
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public abstract class AdBannerAdapter {
	// 总共有多少条
	public abstract int getCount();

	// 根据位置得到图片路径
	public abstract String getImageUrl(int position);

	// 根据位置得到文字描述
	public String getTitleDesc(int position){
		return null;
	}
}
