package com.example.cwd;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

public abstract class AbstractRenderer implements GLSurfaceView.Renderer {

	@Override
	public void onDrawFrame(GL10 g1) {
		g1.glDisable(GL10.GL_DITHER);
		g1.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		g1.glClearColor(.5f, .5f, .5f, 1);
		g1.glShadeModel(GL10.GL_SMOOTH);
		g1.glEnable(GL10.GL_DEPTH_TEST);

	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		float ratio = (float) width / height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glFrustumf(-ratio, ratio, -1, 1, 3, 7);

	}

	@Override
	public void onSurfaceCreated(GL10 g1, EGLConfig config) {

		g1.glDisable(GL10.GL_DITHER);
		g1.glMatrixMode(GL10.GL_MODELVIEW);
		g1.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		g1.glLoadIdentity();
		GLU.gluLookAt(g1, 0, 0, -5, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
		g1.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		draw(g1);

	}

	protected abstract void draw(GL10 gl);

}
