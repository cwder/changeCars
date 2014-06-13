package com.example.cwd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textView_gps;
	TextView textView_net;
	Location location =null;
	
	
	private final int MENU_1=0;  
	private final int MENU_2=1;  
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		
System.out.println("onMenuItemSelected");		
		
		Intent intent = new Intent(MainActivity.this,OpenGL.class);
		startActivity(intent);
		
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		menu.add(0, MENU_1, 0, "aa");
		menu.add(0, MENU_2, 1, "bb");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int a = 1;
		setContentView(R.layout.my_view_test);
		
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			long book_end_time = sdf.parse("2014-01-27 09:53:00").getTime();	
			System.out.println(book_end_time);
			((TextView)findViewById(R.id.txt)).setText("" + book_end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*textView_gps = (TextView) findViewById(R.id.site_gps);
		textView_net = (TextView) findViewById(R.id.site_net);
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				LocationManager locationManager = (LocationManager) MainActivity.this
						.getSystemService(Context.LOCATION_SERVICE);
			

				locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER, 10, 10,
						new MyLocationListener());

				locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10, 10, new MyNetLocationListener());
				
				
				while(location == null){
					((TextView)findViewById(R.id.site_test)).setText("开始获取。。。。");
					location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					if(location!=null){
						((TextView)findViewById(R.id.site_test)).setText("lat   " + location.getLatitude());
					}
				}
				//IntentFilter  in = new IntentFilter("aaaaa");
				Intent intent = new Intent();
				intent.setAction("aaaaa");
				//registerReceiver(new BordCast(), in);
				
				sendBroadcast(intent);
			}
		});
		
		IntentFilter  in = new IntentFilter("aaaaa");
		registerReceiver(new BordCast(), in);*/
		
	}

	class MyLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			if (location != null) {
				textView_gps.setText("经纬度 ：   " + location.getLongitude() + "   "
						+ location.getLatitude());
			}

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			System.out.println("onStatusChanged");
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			System.out.println("onProviderEnabled");
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			System.out.println("onProviderDisabled");
		}

	}
	
	class MyNetLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			if (location != null) {
				textView_net.setText("经纬度 ：   " + location.getLongitude() + "   "
						+ location.getLatitude());
			}

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			System.out.println("onStatusChanged");
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			System.out.println("onProviderEnabled");
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			System.out.println("onProviderDisabled");
		}

	}

}
