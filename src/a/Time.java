package a;

import com.example.cwd.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

public class Time extends Activity {

	private int seconds = 800000;
	private CountDownTimer countDownTimer;
	long one_day = 60 * 60 * 24;
	long one_hour = 60 * 60;
	long one_minute = 60;
	int day, hour, minute, second;
	int zero = R.drawable.p0;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.time);

		

		day = (int) (seconds / one_day);
		hour = (int) (seconds % one_day / one_hour);
		minute = (int) (seconds % one_day % one_hour / one_minute);
		second = (int) (seconds % one_day % one_hour % one_minute);

		countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTick(long millisUntilFinished) {

//System.out.println("day      " + (int) (millisUntilFinished/1000 / one_day));				
//System.out.println("hour      " + (int) (millisUntilFinished/1000 % one_day / one_hour));					
//System.out.println("minute      " + (int) (millisUntilFinished/1000 % one_day % one_hour / one_minute));
//System.out.println("second      " + (int) (millisUntilFinished/1000 % one_day % one_hour % one_minute));

				int day = (int) (millisUntilFinished/1000 / one_day);
				/*if(day.length() == 1){
					day = "0" + day;
				}*/
				
				int hour = (int) (millisUntilFinished/1000 % one_day / one_hour) ;
				/*if(hour.length() == 1){
					hour = "0" + hour;
				}*/
				
				int minute = (int) (millisUntilFinished/1000 % one_day % one_hour / one_minute) ;
				/*if(minute.length() == 1){
					minute = "0" + minute;
				}*/
				
				int second = (int) (millisUntilFinished/1000 % one_day % one_hour % one_minute);
				/*if(second.length() == 1){
					second = "0" + second;
				}*/
				
				
				
				
				((TextView)findViewById(R.id.day)).setText(day + "");
				((TextView)findViewById(R.id.hour)).setText(hour + "");
				((TextView)findViewById(R.id.minute)).setText(minute + "");
				((TextView)findViewById(R.id.second)).setText(second + "");
				
				
				
				
				
				
				
				

				if(day < 10){
					((ImageView)findViewById(R.id.img_1)).setImageResource(zero);
				}else{
					((ImageView)findViewById(R.id.img_1)).setImageResource(zero + day /10);
				}
				
				((ImageView)findViewById(R.id.img_2)).setImageResource(zero +day%10);
				
				if(hour <10){
					((ImageView)findViewById(R.id.img_3)).setImageResource(zero);
				}else{
					((ImageView)findViewById(R.id.img_3)).setImageResource(zero + hour /10);
				}

				((ImageView)findViewById(R.id.img_4)).setImageResource(zero +hour%10);
				
				
				if(minute <10){
					((ImageView)findViewById(R.id.img_5)).setImageResource(zero);
				}else{
					((ImageView)findViewById(R.id.img_5)).setImageResource(zero + minute /10);
				}

				((ImageView)findViewById(R.id.img_6)).setImageResource(zero +minute%10);
				
				

				if(second <10){
					
					((ImageView)findViewById(R.id.img_7)).setImageResource(zero);
				}else{
					
					((ImageView)findViewById(R.id.img_7)).setImageResource(zero + second /10);
				}

				((ImageView)findViewById(R.id.img_8)).setImageResource(zero +second%10);
				
				
				
			}
		};
		countDownTimer.start();
	}

}
