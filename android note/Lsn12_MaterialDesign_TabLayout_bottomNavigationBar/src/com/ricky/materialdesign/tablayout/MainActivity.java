package com.ricky.materialdesign.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private TabLayout tabLayout;
	private String[] title = {
//		"ͷ��",
//		"����",
//		"����",
//		"����",
//		"�Ƽ�",
//		"��Ů",
		"�ƾ�",
		"����",
		"����",
		"ͷ��"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
		tabLayout = (TabLayout)findViewById(R.id.tablayout);
		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
		//1.TabLayout��Viewpager����
//		tabLayout.setOnTabSelectedListener(new OnTabSelectedListener() {
//			
//			@Override
//			public void onTabUnselected(Tab arg0) {
//			}
//			
//			@Override
//			public void onTabSelected(Tab tab) {
//				// ��ѡ�е�ʱ��ص�
//				viewPager.setCurrentItem(tab.getPosition(),true);
//			}
//			
//			@Override
//			public void onTabReselected(Tab arg0) {
//			}
//		});
//		//2.ViewPager��������tabLayout
//		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//		//����tabLayout�ı�ǩ������PagerAdapter
//		tabLayout.setTabsFromPagerAdapter(adapter);
		
		viewPager.setAdapter(adapter);
		//��������һ����λ
		tabLayout.setupWithViewPager(viewPager);
		for (int i = 0; i < tabLayout.getTabCount(); i++) {
			Tab tab = tabLayout.getTabAt(i);
//			tab.setText(Html.toHtml(text))
			View view = View.inflate(this, R.layout.bottom_navigation, null);
			TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
			tv_name.setText(title[i]);
			tab.setCustomView(view);
//			tab.setIcon(icon)
		}
		
	}
	
	class MyPagerAdapter extends FragmentPagerAdapter{

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return title[position];
		}

		@Override
		public Fragment getItem(int position) {
			Fragment f = new NewsDetailFragment();
			Bundle bundle = new Bundle();
			bundle.putString("title", title[position]);
			f.setArguments(bundle);
			return f;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return title.length;
		}
		
	}
	
	
	
}
