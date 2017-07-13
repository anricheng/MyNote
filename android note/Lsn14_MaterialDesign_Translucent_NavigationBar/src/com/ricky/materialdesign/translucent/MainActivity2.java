package com.ricky.materialdesign.translucent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity2 extends BaseTranslucentActivity{

	private Toolbar toolbar;
	private View nav;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		nav = findViewById(R.id.nav);
		setOrChangeTranslucentColor(toolbar, nav, getResources().getColor(R.color.colorPrimary_pink));
		
	}
}
