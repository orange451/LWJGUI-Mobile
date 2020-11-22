package org.lwjgl.opengl;

import java.nio.ByteBuffer;

public class GL11 extends org.mini.gl.GL {
	public static int glGetInteger(int name) {
		int[] dat = new int[1];
		org.mini.gl.GL.glGetIntegerv(name, dat, 0);
		return dat[0];
	}

	public static final int GL_QUADS = 0;

	public static void glBegin(int mode) {
		//
	}

	public static void glColor3f(float f, float g, float h) {
		// TODO Auto-generated method stub
		
	}

	public static void glTexCoord2f(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public static void glVertex2f(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public static void glEnd() {
		// TODO Auto-generated method stub
		
	}

	public static void glTexImage2D(int mode, int mipLevel, int type, int width, int height, int j, int type2, int size, int i) {
		glTexImage2D(mode, mipLevel, type, width, height, j, type2, size, null, i);
	}

	public static void glTexImage2D(int mode, int mipLevel, int type, int wid, int hei, int j, int type2, int size, ByteBuffer data) {
		glTexImage2D(mode, mipLevel, type, wid, hei, j, type2, size, data.array(), data.arrayOffset());
	}

	public static int glGenTextures() {
        int[] t = {0};
        glGenTextures(1, t, 0);
        return t[0];
	}

	public static int glDeleteTextures(int texId) {
		int[] t = {0};
		glDeleteTextures(texId, t, 0);
		return t[0];
	}
}
