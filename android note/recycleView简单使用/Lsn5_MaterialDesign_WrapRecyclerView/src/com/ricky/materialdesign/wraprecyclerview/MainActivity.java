package com.ricky.materialdesign.wraprecyclerview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	private WrapRecyclerView recyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recyclerView = (WrapRecyclerView) findViewById(R.id.recyclerView);
		
		
//		View headerView = View.inflate(this, resource, root);
		TextView headerView = new TextView(this);
		//		TextView tv = headerView.findViewById(id);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		headerView.setLayoutParams(params);
		headerView.setText("我是HeaderView");
		recyclerView.addHeaderView(headerView);
		
		TextView footerView = new TextView(this);
		params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		footerView.setLayoutParams(params);
		footerView.setText("我是FooterView");
		recyclerView.addFooterView(footerView);
		
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			list.add("item "+i); 
		}
		
		MyAdapter adapter = new MyAdapter(list);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
		
	}

}
