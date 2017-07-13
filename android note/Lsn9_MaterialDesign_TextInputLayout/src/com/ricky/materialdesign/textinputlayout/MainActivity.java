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
		//��ⳤ��Ӧ�õ���6λ��
		textInputLayout.getEditText().addTextChangedListener(new MinLengthTextWatcher(textInputLayout, "����Ӧ����6λ��!"));
		
		//��������
		textInputLayout.setCounterEnabled(true);
		textInputLayout.setCounterMaxLength(10);//�������������
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
			// ���ֱ仯ǰ�ص�
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// �ı��ʱ��ص�
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			// ���ָı��ص�
			if(textInputLayout.getEditText().getText().toString().length()<=6){
				textInputLayout.setErrorEnabled(false);
			}else{
				textInputLayout.setErrorEnabled(true);
				textInputLayout.setError(errorStr);
			}
		}
		
	}
	
}
