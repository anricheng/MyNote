package com.example.hui.template.photo.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.hui.template.R;
import com.example.hui.template.adbanner.ImageLoadCouplingUtil;
import com.example.hui.template.photo.view.photoView.PhotoView;

import java.util.ArrayList;
/**
 * 
 * ============================================================
 * 
 * project name : DiDi professor
 * 
 * copyright : ZENG HUI (c) 2014
 * 
 * author : HUI
 * 
 * email : 240336124@QQ.com
 * 
 * version : 1.0
 * 
 * date created : On January 20, 2015 13:32:31
 * 
 * description : Space photo album viewer
 * 
 * revision history :
 * 
 * ============================================================
 *
 */
@SuppressLint("ViewConstructor")
public class PhotoViewPager extends ViewPager {
	private Context context;
	/** image path URL **/
	private ArrayList<String> uriList;
	private PagerAdapter adapter;
	/** Photo browsing progress indication **/
	private TextView mInstructionsNumber;
	/**
	 * Whether to lock the view pager, make pictures when moving block view
	 * pager rolling
	 **/
	private boolean isLocked = false;
	
	//-----------------------set resource to view pager-------------------------

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (!isLocked) {
			return super.onTouchEvent(event);
		}
		return false;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (!isLocked) {
			try {
				return super.onInterceptTouchEvent(ev);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public PhotoViewPager(Context context, TextView instructionsNumber) {
		super(context);
		this.context = context;
		this.mInstructionsNumber = instructionsNumber;
	}

	public void setUriList(ArrayList<String> uriList) {
		this.uriList = uriList;
		this.mInstructionsNumber.setText("1/" + uriList.size());
		startloadResouce();
	}

	private void startloadResouce() {
		this.setOnPageChangeListener(new MyOnPageChangeListener());
		adapter = new ViewPagerAdapter();
		this.setAdapter(adapter);

		// 控制ViewPager切换的效果
		this.setPageTransformer(true, new DepthPageTransformer());
	}

	class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int position) {
			mInstructionsNumber.setText((position + 1) + "/" + uriList.size());
		}

		@Override
		public void onPageScrollStateChanged(int state) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
	}

	class ViewPagerAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return uriList.size();
		}

		@Override
		public Object instantiateItem(View container, final int position) {
			View view = View.inflate(context, R.layout.photo_view_page_item,
					null);
			((ViewPager) container).addView(view);
			PhotoView imageView = (PhotoView) view
					.findViewById(R.id.photo_item);
			imageView.setOnLockListener(new PhotoView.OnLockListener() {
				@Override
				public void onLock(boolean isLock) {
					isLocked = isLock;
				}
			});
			imageView.setAbleZoomMinScale(0.5f);
			imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					((Activity)context).finish();
				}
			});
			ImageLoadCouplingUtil.getInstance().loadImage(uriList.get(position), imageView);
			return view;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView((View) object);
			object = null;
		}
	}
}
