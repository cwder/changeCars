package com.example.cwd;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.R.integer;
import android.content.Context;

public class SimpeRenderer extends AbstractRenderer {

	private final static int VERTS =3;
	private FloatBuffer floatBuffer;
	private ShortBuffer shortBuffer;
	
	public SimpeRenderer(Context context){
		ByteBuffer vbb = ByteBuffer.allocateDirect(VERTS *3*4);
		vbb.order(ByteOrder.nativeOrder());
		floatBuffer = vbb.asFloatBuffer();
		
		ByteBuffer ibb = ByteBuffer.allocateDirect(VERTS *2);
		vbb.order(ByteOrder.nativeOrder());
		shortBuffer = vbb.asShortBuffer();
		
		float[] coords = {-0.5f,-0.5f,0,
						  0.5f,-0.5f,0,
						  0.0f,0.5f,0};
		
		for(int i=0;i<VERTS;i++){
			for(int j=0;j<3;j++){
				floatBuffer.put(coords[i*3+j]);
			}
		}
		
		short[] myIndecesArray = {0,1,2};
		for(int i=0;i<3;i++){
			shortBuffer.put(myIndecesArray[i]);
		}
		
		floatBuffer.position(0);
		shortBuffer.position(0);
		
		
		
		
	}
	
	
	
	@Override
	protected void draw(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glColor4f(1.0f, 0, 0, 0.5f);
		gl.glVertexPointer(3,GL10.GL_FLOAT, 0, floatBuffer);
		
		gl.glDrawElements(GL10.GL_TRIANGLES, VERTS, GL10.GL_UNSIGNED_SHORT, shortBuffer);
	}

}
