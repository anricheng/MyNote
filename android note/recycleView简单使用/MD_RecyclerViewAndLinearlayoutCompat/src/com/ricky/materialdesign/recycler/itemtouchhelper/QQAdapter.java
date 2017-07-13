package com.ricky.materialdesign.recycler.itemtouchhelper;

import java.util.Collections;
import java.util.List;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class QQAdapter extends Adapter<QQAdapter.MyViewHolder> implements ItemTouchMoveListener{
	private List<QQMessage> list;
	private StartDragListener dragListener;

	public QQAdapter(List<QQMessage> list, StartDragListener dragListener) {
		this.list = list;
		this.dragListener = dragListener;
	}
	
	class MyViewHolder extends ViewHolder{

		private ImageView iv_logo;
		private TextView tv_name;
		private TextView tv_Msg;
		private TextView tv_time;

		public MyViewHolder(View itemView) {
			super(itemView);
			iv_logo = (ImageView)itemView.findViewById(R.id.iv_logo);
			tv_name = (TextView)itemView.findViewById(R.id.tv_name);
			tv_Msg = (TextView)itemView.findViewById(R.id.tv_lastMsg);
			tv_time = (TextView)itemView.findViewById(R.id.tv_time);
		}
		
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(final MyViewHolder holder, int location) {
		QQMessage qqMessage = list.get(location);
		holder.iv_logo.setImageResource(qqMessage.getLogo());
		holder.tv_name.setText(qqMessage.getName());
		holder.tv_Msg.setText(qqMessage.getLastMsg());
		holder.tv_time.setText(qqMessage.getTime());
		
		holder.iv_logo.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					//传递触摸情况给谁？
					dragListener.onStartDrag(holder);
				}
				return false;
			}
		});
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
		return new MyViewHolder(view);
	}

	@Override
	public boolean onItemMove(int fromPosition, int toPosition) {
		// 1.数据交换；2.刷新
		Collections.swap(list, fromPosition, toPosition);
		notifyItemMoved(fromPosition, toPosition);
		return true;
	}

	@Override
	public boolean onItemRemove(int position) {
		list.remove(position);
		notifyItemRemoved(position);
		return true;
	}
	
	

}
