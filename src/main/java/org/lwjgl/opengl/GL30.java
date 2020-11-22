package org.lwjgl.opengl;

public class GL30 extends GL20 {

	public static int glDeleteFramebuffers(int fboId) {
		int t[] = {0};
		glDeleteFramebuffers(fboId, t, 0);
		return t[0];
	}

	public static int glDeleteRenderbuffers(int renderId) {
		int t[] = {0};
		glDeleteRenderbuffers(renderId, t, 0);
		return t[0];
	}

	public static int glGenFramebuffers() {
		int[] t = {0};
		glGenFramebuffers(1, t, 0);
		return t[0];
	}

	public static int glGenRenderbuffers() {
		int[] t = {0};
		glGenRenderbuffers(1, t, 0);
		return t[0];
	}

	public static int glDeleteVertexArrays(int vaoId) {
		int[] t = {0};
		glDeleteVertexArrays(vaoId, t, 0);
		return t[0];
	}
	
	public static int glGenVertexArrays() {
		int[] t = {0};
		glGenVertexArrays(1, t, 0);
		return t[0];
	}
}
