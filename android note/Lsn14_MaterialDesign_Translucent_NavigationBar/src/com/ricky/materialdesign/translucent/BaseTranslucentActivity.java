package com.ricky.materialdesign.translucent;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class BaseTranslucentActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//�жϰ汾,���[4.4,5.0)������״̬���͵�����Ϊ͸��
		if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.KITKAT
				&&android.os.Build.VERSION.SDK_INT<android.os.Build.VERSION_CODES.LOLLIPOP){
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			//�������⵼����Ϊ͸��
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}
	}
	
	@SuppressLint("NewApi")
	public void setOrChangeTranslucentColor(Toolbar toolbar,View bottomNavigationBar, int translucentPrimaryColor){
		//�жϰ汾,���[4.4,5.0)������״̬���͵�����Ϊ͸��
		if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.KITKAT
				&&android.os.Build.VERSION.SDK_INT<android.os.Build.VERSION_CODES.LOLLIPOP){
			if(toolbar!=null){
				//1.������toolbar�ĸ߶�
				LayoutParams params = toolbar.getLayoutParams();
				int statusBarHeight = getStatusBarHeight(this);
				params.height += statusBarHeight ;
				toolbar.setLayoutParams(params );
				//2.����paddingTop���Դﵽ״̬�����ڵ�toolbar�����ݡ�
				toolbar.setPadding(
						toolbar.getPaddingLeft(),
						toolbar.getPaddingTop()+getStatusBarHeight(this), 
						toolbar.getPaddingRight(),
						toolbar.getPaddingBottom());
				//���ö�������ɫ
				toolbar.setBackgroundColor(translucentPrimaryColor);
			}
			if(bottomNavigationBar!=null){
				//����Ͱ汾4.4+�����⵼������
				if(hasNavigationBarShow(getWindowManager())){
					LayoutParams p = bottomNavigationBar.getLayoutParams();
					p.height += getNavigationBarHeight(this);
					bottomNavigationBar.setLayoutParams(p);
					//���õײ�����������ɫ
					bottomNavigationBar.setBackgroundColor(translucentPrimaryColor);
				}
			}
		}else if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.LOLLIPOP){
			getWindow().setNavigationBarColor(translucentPrimaryColor);
			getWindow().setStatusBarColor(translucentPrimaryColor);
		}else{
			//<4.4�ģ���������
		}
	}
	

	private int getNavigationBarHeight(Context context) {
		return getSystemComponentDimen(this, "navigation_bar_height");
	}

	/**
	 * ��ȡ״̬���ĸ߶�
	 * @param context
	 * @return
	 */
	private int getStatusBarHeight(Context context) {
		// �����ֻ����е��ࣺandroid.R.dimen.status_bar_height.
		return getSystemComponentDimen(this, "status_bar_height");
	}
	
	private static int getSystemComponentDimen(Context context, String dimenName){
		// �����ֻ����е��ࣺandroid.R.dimen.status_bar_height.
		int statusHeight = -1;
		try {
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			String heightStr = clazz.getField(dimenName).get(object).toString();
			int height = Integer.parseInt(heightStr);
			//dp--->px
			statusHeight = context.getResources().getDimensionPixelSize(height);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusHeight;
	}
	
	private static boolean hasNavigationBarShow(WindowManager wm){
		Display display = wm.getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		//��ȡ������Ļ�ĸ߶�
		display.getRealMetrics(outMetrics);
		int heightPixels = outMetrics.heightPixels;
		int widthPixels = outMetrics.widthPixels;
		//��ȡ����չʾ���ֵĸ߶�
		outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		int heightPixels2 = outMetrics.heightPixels;
		int widthPixels2 = outMetrics.widthPixels;
		int w = widthPixels-widthPixels2;
		int h = heightPixels-heightPixels2;
		System.out.println("~~~~~~~~~~~~~~~~h:"+h);
		return  w>0||h>0;//�����ͺ������������
	}
	
}
