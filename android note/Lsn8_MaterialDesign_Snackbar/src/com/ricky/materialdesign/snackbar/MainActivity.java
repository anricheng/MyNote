package com.ricky.materialdesign.snackbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.Callback;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void showCustomToast(View v){
//		Toast.makeText(this, "��˾", 0).show();
		Toast result = new Toast(this);

        LayoutInflater inflate = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflate.inflate(R.layout.custom_toast, null);
        TextView tv = (TextView)view.findViewById(R.id.textView1);
        tv.setText("�Զ�����˾�ڴˣ�");
        
//        result.setGravity(gravity, xOffset, yOffset)
        result.setView(view);
        result.setDuration(Toast.LENGTH_LONG);
		result.show();
	}
	
	public void showSnackbar(View v){
		//LENGTH_INDEFINITE:����
		Snackbar snackbar = Snackbar.make(v, "�Ƿ�������ģʽ��", Snackbar.LENGTH_INDEFINITE);
		snackbar.setAction("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showCustomToast(null);
			}
		});
		//�������ö��action���ᱻ����
		snackbar.setAction("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showCustomToast(null);
			}
		});
		snackbar.setCallback(new Callback() {
			
			@Override
			public void onDismissed(Snackbar snackbar, int event) {
				// TODO Auto-generated method stub
				showCustomToast(null);
				super.onDismissed(snackbar, event);
			}
			
			@Override
			public void onShown(Snackbar snackbar) {
				// TODO Auto-generated method stub
				super.onShown(snackbar);
			}
		});
		snackbar.setActionTextColor(Color.RED);
		snackbar.show();
		
	}

}
