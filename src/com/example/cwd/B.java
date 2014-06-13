package com.example.cwd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;


import com.example.cwd.MyService.MyBind;

import a.MyView;
import android.R.integer;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class B extends Activity {

	private MyView myView;

	private int i = 0;
	private String url = "http://www.people.com.cn/mediafile/pic/20130123/31/1230533590357165923.jpg";
	String url_2 = "http://test.mapin.com.cn/uploads/user/check_in/120_120/20130613133652e1ee1486c215e0cdef6cb2c06df9aff6.png";
	private ImageView imageView;
	int densityDpi;
	private String root = Environment.getExternalStorageDirectory() + "/a.jpg";
	
	int w,h;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b);
		
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CommonDBAdapter adapter = CommonDBAdapter.getInstance(B.this);
				adapter.open();
				adapter.initDataBase();
				adapter.save();
				
			}
		});
		

		
	}
	
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			
			Bitmap mBitmap = (Bitmap) msg.obj;
			imageView.setImageBitmap(mBitmap);
			mBitmap.recycle();
			mBitmap = null;
		}
		
	};
	
	
	class HttpThread extends Thread{

		
		
		@Override
		public void run() {
			
			try {
				File file = new File(root);
				file.createNewFile();
				HttpURLConnection connection = (HttpURLConnection) new URL(url_2).openConnection();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				InputStream inputStream = connection.getInputStream();
				
				byte[] buf = new byte[1024];
				
				int i = 0;
				while(true){
					i = inputStream.read(buf);
					if(i<0){
						break;
					}
					fileOutputStream.write(buf, 0, i);
				}
				
				fileOutputStream.flush();
				
				
/*System.out.println("ok");				
				Bitmap bitmap = null;
				Options op = new Options();
				
				op.inJustDecodeBounds = true;
				op.inTargetDensity = densityDpi;
				op.inDensity = 320;
				
				op.inTargetDensity = densityDpi;
				op.inDensity = 2;
				BitmapFactory.decodeFile(file.getPath(),op);
System.out.println("op.inTargetDensity   " + op.inTargetDensity);				
System.out.println("op.inDensity   " + op.inDensity);
				op.inJustDecodeBounds = false;

				bitmap = BitmapFactory.decodeFile(file.getPath(),op);
System.out.println("bitmap   " + bitmap);				
				handler.sendMessage(handler.obtainMessage(1, bitmap));*/
				
				
				
				
				
				
				
				
				handler.sendMessage(handler.obtainMessage(1, getBitmapFromFile(file.getPath())));	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}
	
	private Bitmap getBitmapFromFile(String path) {
		Bitmap bm = null;
		Options op = new Options();
		op.inJustDecodeBounds = true;
		op.inTargetDensity = densityDpi;
		op.inDensity = 2;
		BitmapFactory.decodeFile(path, op);
		op.inJustDecodeBounds = false;

		if (op.outWidth > w) {
			op.inSampleSize = (int) ((float) op.outWidth / w + 1);
System.out.println("op.inSampleSize   " + op.inSampleSize);
			bm = BitmapFactory.decodeFile(path, op);
			if (bm != null) {
				Bitmap temp = bm;
				bm = Bitmap.createScaledBitmap(bm, w,
						(int) (op.outHeight * w / (float) op.outWidth), true);
				temp.recycle();
				temp = null;
			}
		} else {
			bm = BitmapFactory.decodeFile(path, op);
		}
		return bm;
	}
	
	
	class MyConn implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			MyBind bind = (MyBind) service;
			((TextView)findViewById(R.id.txt)).setText(bind.get());
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
