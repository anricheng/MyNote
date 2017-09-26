package com.example.hui.template.common.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by hui on 2016/10/11.
 */
public abstract class CommonAdapter<T> extends BaseAdapter{

    // 显示的是谁的数据  团队列表TeamBean
    protected Context mContext;
    protected List<T> mDatas;

    private int layoutId;

    public CommonAdapter(Context context,List<T> datas,int layoutId){
        this.mContext = context;
        this.mDatas = datas;
        this.layoutId = layoutId;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. getCount()   getItem()  getItemId()

        // 2. ViewHolder

        // 3. findViewBy   setText  setImageUrl setImageResource


        // 4.viewHolder  T 交给子类调用


        ViewHolder viewHolder = ViewHolder.getHolder(mContext,convertView, layoutId);

        // 把设置参数的内容传递给子类
        convert(viewHolder,mDatas.get(position),position);

        return viewHolder.getConvertView();
    }

    protected abstract void convert(ViewHolder viewHolder, T t, int position);
}
