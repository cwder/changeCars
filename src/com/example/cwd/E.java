package com.example.cwd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;

public class E extends Activity{

	ScrollView scrollView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.e);
		scrollView = (ScrollView) findViewById(R.id.scroll);
		findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scrollView.scrollTo(0, 100);  
				/*scrollview.post(new Runnable() {  
					  
					@Override  
					public void run() {  
					scrollview.scrollTo(0, 30);  
					}  
					});  */
			}
		});
		
	}

}
