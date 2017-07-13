package com.ricky.materialdesign.translucent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//����״̬����͸������
//		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)//ȫ��
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		//�������⵼����Ϊ͸��
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//		getWindow().setNavigationBarColor(getResources().getColor(R.color.system_bottom_nav_color));
//		getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary_pink));
		setContentView(R.layout.activity_main);
		//5.0+����ֱ����API���޸�״̬������ɫ��
//		getWindow().setStatusBarColor(getResources().getColor(R.color.material_blue_grey_800));
		//1.������toolbar�ĸ߶�
		toolbar = (Toolbar)findViewById(R.id.toolbar);
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
//		 
		
		//����Ͱ汾4.4+�����⵼������
		View nav = findViewById(R.id.nav);
		LayoutParams p = nav.getLayoutParams();
		p.height += getNavigationBarHeight(this);
		nav.setLayoutParams(p);
		
		
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
	
	public static int getSystemComponentDimen(Context context, String dimenName){
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
