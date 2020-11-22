package org.lwjgl.system;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.PointerBuffer;

public class MemoryStack implements AutoCloseable {
	
	private MemoryStack() {
		//
	}

	public static MemoryStack stackPush() {
		return new MemoryStack();
	}

	public PointerBuffer mallocPointer(int i) {
		return new PointerBuffer();
	}

	public String UTF8(String string) {
		return "";
	}

	public void pop() {
		//
	}
	
	public static FloatBuffer stackMallocFloat(int size) {
		return FloatBuffer.allocate(size);
	}
	
	public static void stackPop() {
		//
	}

    /**
     * Calls {@link #pop} on this {@code MemoryStack}.
     *
     * <p>This method should not be used directly. It is called automatically when the {@code MemoryStack} is used as a resource in a try-with-resources
     * statement.</p>
     */
    @Override
    public void close() {
        pop();
    }

	public IntBuffer mallocInt(int i) {
		return IntBuffer.allocate(i);
	}
}
