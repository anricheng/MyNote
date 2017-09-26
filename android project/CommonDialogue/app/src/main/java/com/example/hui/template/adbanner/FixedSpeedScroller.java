package com.example.hui.template.adbanner;

import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;

/**
 * 
 * ============================================================
 * 
 * copyright ZENG　HUI (c) 2014
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On November 20, 2014 9:30:34
 * 
 * description : The rate at which is used to adjust the viewPager
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class FixedSpeedScroller extends Scroller {

	private int mDuration = 1500; // default time is 1500ms

	public FixedSpeedScroller(Context context) {
		super(context);
	}

	public FixedSpeedScroller(Context context,
							  AccelerateInterpolator accelerateInterpolator) {
		super(context, accelerateInterpolator);
	}

	/**
	 * 
	 * @param time
	 *            : The rate of rolling , In milliseconds.
	 */
	public void setmDuration(int time) {
		mDuration = time;
	}

	public int getmDuration() {
		return mDuration;
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy, int duration) {
		super.startScroll(startX, startY, dx, dy, mDuration);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy) {
		super.startScroll(startX, startY, dx, dy, mDuration);
	}

}
