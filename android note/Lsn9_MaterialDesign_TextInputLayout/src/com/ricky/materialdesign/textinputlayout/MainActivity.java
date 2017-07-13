package com.ricky.materialdesign.textinputlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {

	private TextInputLayout textInputLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textInputLayout = (TextInputLayout)findViewById(R.id.textInputLayout);
		//检测长度应该低于6位数
		textInputLayout.getEditText().addTextChangedListener(new MinLengthTextWatcher(textInputLayout, "长度应低于6位数!"));
		
		//开启计数
		textInputLayout.setCounterEnabled(true);
		textInputLayout.setCounterMaxLength(10);//最大输入限制数
	}

	class MinLengthTextWatcher implements TextWatcher{

		private String errorStr;
		private TextInputLayout textInputLayout;

		public MinLengthTextWatcher(TextInputLayout textInputLayout, String errorStr) {
			// TODO Auto-generated constructor stub
			this.textInputLayout = textInputLayout;
			this.errorStr = errorStr;
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// 文字变化前回调
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// 改变的时候回调
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			// 文字改变后回调
			if(textInputLayout.getEditText().getText().toString().length()<=6){
				textInputLayout.setErrorEnabled(false);
			}else{
				textInputLayout.setErrorEnabled(true);
				textInputLayout.setError(errorStr);
			}
		}
		
	}
	
}
