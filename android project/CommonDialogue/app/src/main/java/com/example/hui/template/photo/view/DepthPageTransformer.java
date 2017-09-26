package com.example.hui.template.photo.view;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

@SuppressLint("NewApi")
public class DepthPageTransformer implements PageTransformer {
	private static final float MIN_SCALE = 0.75f;

	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		if (position <= -1) {
			return;
		}
		if (position < -1) { // [-Infinity,-1)
			// 动画   兼容 2.3 以下
			ViewHelper.setAlpha(view, 0);
		} else if (position <= 0) { // [-1,0]
			// Use the default slide transition when moving to the left page
			ViewHelper.setAlpha(view, 1);
			ViewHelper.setTranslationX(view, 0);
			ViewHelper.setScaleX(view, 1);
			ViewHelper.setScaleY(view, 1);

		} else if (position <= 1) { // (0,1]
			// Fade the page out.
			ViewHelper.setAlpha(view, 1 - position);

			// Counteract the default slide transition
			ViewHelper.setTranslationX(view, pageWidth * -position);

			// Scale the page down (between MIN_SCALE and 1)
			float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
					* (1 - Math.abs(position));
			ViewHelper.setScaleX(view, scaleFactor);
			ViewHelper.setScaleY(view, scaleFactor);

		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			ViewHelper.setAlpha(view, 0);
		}
	}
}