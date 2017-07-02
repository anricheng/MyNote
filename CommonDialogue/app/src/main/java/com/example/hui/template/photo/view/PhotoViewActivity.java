package com.example.hui.template.photo.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hui.template.R;

import java.util.ArrayList;


public class PhotoViewActivity extends Activity{
	private LinearLayout mRescoPhotoContainer;
	private TextView mInstructionsPhotoNumberTv;
	/****************************************/
	private ArrayList<String> mImageUrls;
	public static final String IMAGE_URL_LIST_KEY = "IMAGE_URL_LIST_KEY";
	/****************************************/
	private int mCurrentPoint = 0;
	public static final String CURRENT_POINT_KEY = "CURRENT_POINT_KEY";
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        // 找到控件
        mRescoPhotoContainer = (LinearLayout) findViewById(R.id.resco_photo);
		// 获取参数
        mCurrentPoint = getIntent().getIntExtra(CURRENT_POINT_KEY, mCurrentPoint);// 当前点击的位置
        mImageUrls = getIntent().getStringArrayListExtra(IMAGE_URL_LIST_KEY);// 总的图片链接ArrayList

        mInstructionsPhotoNumberTv = (TextView) findViewById(R.id.instructions_photo_number);
		
        // 设置内容
        PhotoViewPager pager = new PhotoViewPager(this,mInstructionsPhotoNumberTv);
		pager.setUriList(mImageUrls);
		pager.setCurrentItem(mCurrentPoint);
		mRescoPhotoContainer.removeAllViews();
		mRescoPhotoContainer.addView(pager);
	}
}
