package org.lwjgl.system;

import java.nio.ByteBuffer;

public class MemoryUtil {
	public static final long NULL = 0;
	
	public static void memFree(ByteBuffer data) {
		//
	}
	
	public static ByteBuffer memAlloc(int size) {
		return ByteBuffer.allocate(size);
	}
	
	public static ByteBuffer memRealloc(ByteBuffer buffer, int size) {
		ByteBuffer nBuf = memAlloc(size);
		
		buffer.flip();
		while(buffer.hasRemaining()) {
			nBuf.put(buffer.get());
		}
		
		return nBuf;
	}
}
