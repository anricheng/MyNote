package com.ricky.materialdesign.recyclerview;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class MyStaggedRecyclerAdapter extends RecyclerView.Adapter<MyStaggedRecyclerAdapter.MyViewHolder> {

	private List<String> list;
	private List<Integer> heights;

	public MyStaggedRecyclerAdapter(List<String> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
		
		heights = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			heights.add((int) Math.max(200,Math.random()*550));
		}
		
	}
	
	class MyViewHolder extends RecyclerView.ViewHolder{
		TextView tv;

		public MyViewHolder(View view) {
			super(view);
			tv = (TextView)view.findViewById(android.R.id.text1);
//			tv = (TextView)view.findViewById(R.id.tv);
			
		}
		
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		//绑定数据
		LayoutParams params = holder.tv.getLayoutParams();
		params.height = heights.get(position);
		holder.tv.setBackgroundColor(Color.rgb(100, (int)(Math.random()*255), (int)(Math.random()*255)));
		holder.tv.setLayoutParams(params);
		holder.tv.setText(list.get(position));
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int arg1) {
		// 创建ViewHolder
//		MyViewHolder holder = new MyViewHolder(View.inflate(viewGroup.getContext(), R.layout.listitem, null));
//		MyViewHolder holder = new MyViewHolder(View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null));
//		MyViewHolder holder = new MyViewHolder(View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, viewGroup));
		MyViewHolder holder = new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate( android.R.layout.simple_list_item_1, viewGroup,false));
		return holder;
	}
}
