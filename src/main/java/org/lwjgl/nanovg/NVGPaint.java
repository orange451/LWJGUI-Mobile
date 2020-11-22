package org.lwjgl.nanovg;

import org.lwjgl.system.MemoryStack;

public class NVGPaint {
	private byte[] data = new byte[1];
	
	private NVGPaint() {
		//
	}

	public static NVGPaint create() {
		return new NVGPaint();
	}

	public byte[] get() {
		return this.data;
	}

	public void set(byte[] data) {
		this.data = data;
	}

	public static NVGPaint callocStack(MemoryStack stack) {
		return create();
	}

	public static NVGPaint mallocStack(MemoryStack stack) {
		return create();
	}
}
