package com.example.hui.template.common.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hui.template.adbanner.ImageLoadCouplingUtil;

/**
 * Created by hui on 2016/10/11.
 */
public class ViewHolder {

    // 实例化我们的convertView
    private View convertView;

    // 存储View
    // Map<Integer,View> mViews = new HashMap<>();
    // SparseArrays map integers to Objects. Unlike a normal array of Objects, there can be gaps in the indices.
    // It is intended to be more efficient than using a HashMap to map Integers to Objects.
    SparseArray  mViews = new SparseArray();

    public ViewHolder(Context context,View convertView, int layoutId) {
        // 实例化我们的convertView  布局条目的View
        convertView = View.inflate(context,layoutId,null);

        // 设置  convertView.setTag(viewHolder);
        convertView.setTag(this);

        this.convertView = convertView;
    }

    public static ViewHolder getHolder(Context context,View convertView,int layoutId){
        if(convertView == null){
            ViewHolder viewHolder = new ViewHolder(context,convertView, layoutId);
            return viewHolder;
        }else{
            return (ViewHolder)convertView.getTag();
        }
    }

    public View getConvertView(){
        return convertView;
    }

    /**
     * 设置文本
     * @param viewId  根布局里面的Id
     * @param item   给该TextView设置的内容
     * @return ViewHolder  为了给调用者   可以用链式调用
     */
    public ViewHolder setText(int viewId, String item) {
        // 减少findViewById的次数
        TextView tv = getView(viewId);
        tv.setText(item);
        return this;
    }


    /**
     * 设置资源图片
     * @param viewId 根布局里面的Id
     * @param resourceId 给该ImageView设置的资源
     */
    public ViewHolder setImageResource(int viewId, int resourceId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resourceId);
        return this;
    }


    /**
     * 设置网络图片
     * @param viewId 根布局里面的Id
     * @param url 网络图片路径
     */
    public ViewHolder setImageUrl(int viewId, String url) {
        ImageView iv = getView(viewId);
        // 加载网络图片
        ImageLoadCouplingUtil.getInstance().loadImage(url,iv);
        return this;
    }

    /**
     * 根据View的Id 获取 View
     */
    public  <T extends View> T getView(int viewId){
        // 去缓存集合中找
        View view = (View) mViews.get(viewId);

        if(view == null){
            // 如果是第一次
            view = convertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }


}
