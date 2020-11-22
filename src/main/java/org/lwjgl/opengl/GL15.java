package org.lwjgl.opengl;

import java.nio.FloatBuffer;

public class GL15 extends GL11 {

	public static int glDeleteBuffers(int vboId) {
		int[] t = {0};
		glDeleteBuffers(vboId, t, 0);
		return t[0];
	}
	
	public static void glBufferData(int type, FloatBuffer data, int mode) {
		float[] debugBox = data.array();
		glBufferData(type, debugBox.length * Float.BYTES, debugBox, 0, mode);
	}
	
	public static int glGenBuffers() {
		int t[] = {0};
		glGenBuffers(1, t, 0);
		return t[0];
	}
}
