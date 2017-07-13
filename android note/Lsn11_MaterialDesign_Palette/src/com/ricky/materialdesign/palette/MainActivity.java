package com.ricky.materialdesign.palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.PaletteAsyncListener;
import android.support.v7.graphics.Palette.Swatch;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private ImageView iv;
	private TextView tv_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView)findViewById(R.id.iv);
		
		tv_title = (TextView)findViewById(R.id.tv_title);
		final TextView tv1 = (TextView)findViewById(R.id.tv1);
		final TextView tv2 = (TextView)findViewById(R.id.tv2);
		final TextView tv3 = (TextView)findViewById(R.id.tv3);
		final TextView tv4 = (TextView)findViewById(R.id.tv4);
		final TextView tv5 = (TextView)findViewById(R.id.tv5);
		final TextView tv6 = (TextView)findViewById(R.id.tv6);
		
		BitmapDrawable drawable = (BitmapDrawable) iv.getDrawable();
		Bitmap bitmap = drawable.getBitmap();
		//�õ�bitmap����ĵ�һЩɫ����Ϣ---ͨ��Palette�����������
//		Palette palette = Palette.generate(bitmap);
		//�첽����---���ܷ�����ͼƬ��Ƚϴ������ɫ�ֲ��Ƚϸ��ӣ����ʱ�ȽϾã���ֹ�������̡߳�
		Palette.from(bitmap).generate(new PaletteAsyncListener() {
			
			@Override
			public void onGenerated(Palette palette) {
				//������͵���ɫ
				int darkMutedColor = palette.getDarkMutedColor(Color.BLUE);//����������������򷵻�Ĭ����ɫ
				//�������
				int lightMutedColor = palette.getLightMutedColor(Color.BLUE);
				//��������
				int darkVibrantColor = palette.getDarkVibrantColor(Color.BLUE);
				//��������
				int lightVibrantColor = palette.getLightVibrantColor(Color.BLUE);
				//���
				int mutedColor = palette.getMutedColor(Color.BLUE);
				//���
				int vibrantColor = palette.getVibrantColor(Color.BLUE);
				//��ȡĳ��������ɫ����Ʒ
//				Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
				Swatch lightVibrantSwatch = palette.getVibrantSwatch();
				//�ȸ��Ƽ��ģ�ͼƬ���������ɫrgb�Ļ��ֵ---��ɫ��
				int rgb = lightVibrantSwatch.getRgb();
				//�ȸ��Ƽ���ͼƬ�м��������ɫ
				int bodyTextColor = lightVibrantSwatch.getBodyTextColor();
				//�ȸ��Ƽ�����Ϊ�������ɫ����һ���ĺ�ͼƬ�ĶԱȶȵ���ɫֵ��
				int titleTextColor = lightVibrantSwatch.getTitleTextColor();
				//��ɫ����
				float[] hsl = lightVibrantSwatch.getHsl();
				//��������ɫ��ͼƬ����ռ�����ض���ֵ
				int population = lightVibrantSwatch.getPopulation();
				
				
				
				tv_title.setBackgroundColor(getTranslucentColor(0.6f,rgb));
				tv_title.setTextColor(titleTextColor);
				
				tv1.setBackgroundColor(darkMutedColor);
				tv1.setText("darkMutedColor");
				tv2.setBackgroundColor(lightMutedColor);
				tv2.setText("lightMutedColor");
				tv3.setBackgroundColor(darkVibrantColor);
				tv3.setText("darkVibrantColor");
				tv4.setBackgroundColor(lightVibrantColor);
				tv4.setText("lightVibrantColor");
				tv5.setBackgroundColor(mutedColor);
				tv5.setText("mutedColor");
				tv6.setBackgroundColor(vibrantColor);
				tv6.setText("vibrantColor");
				
			}
		});
		
		
	}

	/**
	 * 1101 0111 1000 1011
	 * 			 1111 1111
	 * 			 1000 1011
	 */
	protected int getTranslucentColor(float percent, int rgb) {
		// 10101011110001111
		int blue = Color.blue(rgb);
		int green = Color.green(rgb);
		int red = Color.red(rgb);
		int alpha = Color.alpha(rgb);
//		int blue = rgb & 0xff;
//		int green = rgb>>8 & 0xff;
//		int red = rgb>>16 & 0xff;
//		int alpha = rgb>>>24;
		
		alpha = Math.round(alpha*percent);
		Toast.makeText(this, "alpha:"+alpha+",red:"+red+",green:"+green, 1).show();
		return Color.argb(alpha, red, green, blue);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
