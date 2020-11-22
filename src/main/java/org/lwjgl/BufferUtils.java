package org.lwjgl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class BufferUtils {

	public static ByteBuffer createByteBuffer(int size) {
		return ByteBuffer.allocate(size);
	}

	public static FloatBuffer createFloatBuffer(int size) {
		return FloatBuffer.allocate(size);
	}

}
