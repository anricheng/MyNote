package com.ricky.materialdesign.recyclerview;

import java.util.ArrayList;

import com.ricky.materialdesign.recyclerview.MyRecyclerAdapter.OnItemClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RecyclerView recylerview;
	private ArrayList<String> list;
	private MyRecyclerAdapter adapter;
//	private MyStaggedRecyclerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		list = new ArrayList<String>();
		for (int i = 0; i < 60; i++) {
			list.add("item"+i);
		}
		
		recylerview = (RecyclerView)findViewById(R.id.recylerview);
		adapter = new MyRecyclerAdapter(list);
//		adapter = new MyStaggedRecyclerAdapter(list);
		//LayoutManager���ְڷŹ�����(���԰ڷš��ٲ���)
		recylerview.setLayoutManager(new LinearLayoutManager(this));//Ĭ�ϴ�ֱ
		//reverseLayout:���ݵ��ã����ұ߿�ʼ����
//		recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
//		recylerview.setLayoutManager(new GridLayoutManager(this, 3));
		//�ٲ���Ч��
//		recylerview.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
		recylerview.setAdapter(adapter);
		
		recylerview.setItemAnimator(new DefaultItemAnimator());
		adapter.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(MainActivity.this, "���Ҹ���"+position, 0).show();
			}
		});
	}
	
	boolean isGrid = false;
	
	public void change(View v){
		if(!isGrid){
			recylerview.setLayoutManager(new GridLayoutManager(this, 3));
		}else{
			recylerview.setLayoutManager(new LinearLayoutManager(this));//Ĭ�ϴ�ֱ
		}
		isGrid = !isGrid;
	}
	
	public void addItem(View v){
		adapter.addData(3);
	}
	
	
}
