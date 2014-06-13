package a;

import com.example.cwd.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarAct extends Activity{
	private SeekBar seekBar;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbar);
		seekBar = (SeekBar) findViewById(R.id.seekbar);
		textView = (TextView) findViewById(R.id.txt);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				textView.setText("拖动完毕");
System.out.println("onStopTrackingTouch");
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				textView.setText("拖动中...");
System.out.println("onStartTrackingTouch");				

			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				textView.setText("当前值:"+progress);
System.out.println("onProgressChanged");				
			}
		});
	}

	
	
}
