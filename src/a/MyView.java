package a;

import com.example.cwd.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View{

	private Paint mPaint;  
    private Context mContext;  
	public MyView(Context context) {
		super(context);
		mPaint = new Paint();  
	}
	

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();  
		TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.button);
		int color = attrs.getAttributeIntValue("http://schemas.android.com/apk/res/com.example.cwd", "textColor", 1);
		
		
/*		float size = attrs.getAttributeFloatValue("http://schemas.android.com/apk/res/com.example.cwd", "textSize", 2f);
		
	
System.out.println("size   " + size);	*/			
	}

}
