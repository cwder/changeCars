package com.example.cwd;

import android.R.integer;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class C extends Activity {
	
	private TextView textView;
	private Button button;
	private ImageView imageView;
	ListView listView;
	private String[] str = new String[]{"aaa","bbbb","aaa","bbbb","aaa","bbbb","aaa","bbbb","aaa","bbbb","aaa","bbbb"};
	
	private int i = 10;
	
	private SilderView silderView;
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
System.out.println("aaa");			
			if(i<200){
				add();
				handler.sendEmptyMessageAtTime(1, 500);
			}
			
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c);
		
		silderView = (SilderView) findViewById(R.id.silderView);
		textView = (TextView) findViewById(R.id.txt);
		textView.setDrawingCacheEnabled(true);
		textView.buildDrawingCache();
		imageView = (ImageView) findViewById(R.id.img);
		listView = (ListView) findViewById(R.id.list);
		
		listView.setAdapter(new Adapt());
		silderView.upLayout = (FrameLayout) findViewById(R.id.child);
		
		findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//handler.sendEmptyMessageAtTime(1, 500);
				silderView.openOrCloseUpView();
				
				
			}
		});
	}
	
	private void add(){
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lp.setMargins(0,0,0,i);				
		imageView.setLayoutParams(lp);
		i++;
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
				convertView = LayoutInflater.from(C.this).inflate(R.layout.item, null);
			}
			
			((TextView)convertView.findViewById(R.id.txt)).setText(str[position]);
			
			
			return convertView;
		}
		
	}
}
