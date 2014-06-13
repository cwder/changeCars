package com.example.cwd;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class OpenGL extends Activity {

	private GLSurfaceView surfaceView;
	
	private GLSurfaceView.Renderer renderer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		surfaceView = new GLSurfaceView(this);
		surfaceView.setEGLConfigChooser(false);
		surfaceView.setRenderer(new SimpeRenderer(this));
		surfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
		setContentView(surfaceView);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		surfaceView.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		surfaceView.onPause();
	}
	
	
	
	
}
