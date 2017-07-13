package com.ricky.materialdesign.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnCloseListener;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		//����NavigationIcon�ĵ���¼����������緵�ذ�ť��
		// app:navigationIcon="@drawable/abc_ic_ab_back_mtrl_am_alpha"
		toolbar.setNavigationOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		//SearchView��Menu����
		MenuItem item = menu.findItem(R.id.action_search);
		SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
		//����һ������ֱ�ӳ���������---SearchView
//		searchView.setIconified(false);
		//�����ͳ����������Ҳ��ܱ�����
//		searchView.setIconifiedByDefault(false);
		//��ʱ��������Ҫʵ���Զ�����չЧ��
		//ͨ�����룬searchView�õ���һ�����֣�ȥappcompat�����ҵ�abc_search_view.xml,������Ŀؼ�������
		ImageView icon = (ImageView) searchView.findViewById(R.id.search_go_btn);
		icon.setImageResource(R.drawable.abc_ic_voice_search_api_mtrl_alpha);
		icon.setVisibility(View.VISIBLE);
//		searchView.setMaxWidth(200);
		
		SearchView.SearchAutoComplete et = (SearchView.SearchAutoComplete) searchView.findViewById(R.id.search_src_text);
		et.setHint("������Ʒ��������ĸ");
		et.setHintTextColor(Color.WHITE);
		
		
		//�����ύ��ť�Ƿ����(�ɼ�)
		searchView.setSubmitButtonEnabled(true);
		
//		icon.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(MainActivity.this, "�ύ", 1).show();
//			}
//		});
		
		//��ҵ����AutoCompleteTextViewһ��ʹ����ʾ
//		searchView.setSuggestionsAdapter(adapter)
		//��������ı�
		searchView.setOnQueryTextFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				
			}
		});
		//searchView�Ĺرռ���
		searchView.setOnCloseListener(new OnCloseListener() {
			
			@Override
			public boolean onClose() {
				// TODO Auto-generated method stub
				return false;
			}
		});
		searchView.setOnSearchClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "�ύ", 0).show();
			}
		});
		//�����ı��仯�����ò�ѯ
		searchView.setOnQueryTextListener(new OnQueryTextListener() {
			
			@Override
			public boolean onQueryTextSubmit(String text) {
				//�ύ�ı�
				Toast.makeText(MainActivity.this, "�ύ�ı�:"+text, 0).show();
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String text) {
				// �ı��ı��ʱ��ص�
				System.out.println("�ı��仯~~~~~"+text);
				
				return false;
			}
		});
		
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
