package com.example.cwd;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FF extends Activity{
	private ListView listView;
	private String[] str = new String[]{"aaa","bbbb","aaa","bbbb","aaa","bbbb","aaa","bbbb","aaa","bbbb","aaa","bbbb"};
	private ImageView imageView;
	SilderView silderView;
	FrameLayout frameLayout;
	boolean f;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.f);
		listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(new Adapt());
		imageView = (ImageView) findViewById(R.id.img);
		frameLayout = (FrameLayout) findViewById(R.id.img_lay);
		silderView = (SilderView) findViewById(R.id.silderView);
		silderView.upLayout = frameLayout;
		findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 /* LayoutParams p=imageView.getLayoutParams();
				 p.height = 100;
				 imageView.setLayoutParams(p);
				 System.out.println("h   " + imageView.getHeight());*/
				if(!f){
					silderView.openOrCloseUpView();
					imageView.setScaleType(ImageView.ScaleType.CENTER);
					imageView.setBackgroundResource(R.drawable.asde);
					
				f = !f;
				}else{
					silderView.closeOrCloseUpView();
					imageView.setBackgroundResource(R.drawable.asde);
					f = !f;
					imageView.setScaleType(ImageView.ScaleType.CENTER);
				}
				
			}
		});
		
		
	}
	
	class Adapt extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return str.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return str[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			if(convertView==null){
				convertView = LayoutInflater.from(FF.this).inflate(R.layout.item, null);
			}
			
			((TextView)convertView.findViewById(R.id.txt)).setText(str[position]);
			
			
			return convertView;
		}
		
	}
	
}
