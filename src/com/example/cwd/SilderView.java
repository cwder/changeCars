package com.example.cwd;



import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.Scroller;
import android.widget.FrameLayout.LayoutParams;

public class SilderView extends FrameLayout{
	
	public int window_width;
	public int window_height;
	private Scroller scroller;
	private LayoutInflater mInflater;
	public FrameLayout upLayout;

	public SilderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context, attrs);
	}

	public SilderView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	

	public SilderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context, attrs);
	}
	
	private void initView(Context context, AttributeSet attrs) {
		mInflater = LayoutInflater.from(context);
		scroller = new Scroller(context);
		window_width = ((Activity) context).getWindowManager()
				.getDefaultDisplay().getWidth();
		window_height = ((Activity) context).getWindowManager()
				.getDefaultDisplay().getHeight();
	}
	
	public void openOrCloseUpView() {		
		LayoutParams lv = (LayoutParams)upLayout.getLayoutParams();
		scroller.startScroll(0, 150, 0, -50, 5000);
		 invalidate();
		
		
	}
	
	public void closeOrCloseUpView() {		
		LayoutParams lv = (LayoutParams)upLayout.getLayoutParams();
		
		
	
		 scroller.startScroll(0, 100, 0, 50, 5000);
		 invalidate();
		
		
	}

	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		if (scroller.computeScrollOffset()) {
			int i = this.scroller.getCurrY();
			
System.out.println("i  " + i);	
		LayoutParams lp = (LayoutParams)upLayout. getLayoutParams();
		lp.height = i;
		upLayout.setLayoutParams(lp);
			invalidate();
			//postInvalidate();
			/*LayoutParams lp = (LayoutParams)upLayout. getLayoutParams();
			lp.bottomMargin = lv.bottomMargin + i;
			setLayoutParams(lp);
			invalidate();*/
		}
	}
	
	public FrameLayout getUpLayout() {
		return upLayout;
	}

	public void setUpLayout(FrameLayout upLayout) {
		this.upLayout = upLayout;
	}

	
	

}
