package com.ricky.materialdesign.recycler.itemtouchhelper;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

public class MainActivity extends Activity implements StartDragListener{

	private RecyclerView recyclerView;
	private ItemTouchHelper itemTouchHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		recyclerView = (RecyclerView)findViewById(R.id.recyclerview); 
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		
		List<QQMessage> list = DataUtils.init();
		QQAdapter adapter = new QQAdapter(list,this);
		recyclerView.setAdapter(adapter);
		//ÌõÄ¿´¥Ãþ°ïÖúÀà
		ItemTouchHelper.Callback callback = new MyItemTouchHelperCallback(adapter);
		itemTouchHelper = new ItemTouchHelper(callback);
		itemTouchHelper.attachToRecyclerView(recyclerView);
		
	}

	@Override
	public void onStartDrag(ViewHolder viewHolder) {
		itemTouchHelper.startDrag(viewHolder);
	}

}
