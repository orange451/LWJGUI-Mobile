package org.lwjgl.nanovg;

public class NVGColor {
	private float[] data = new float[4];
	
	private NVGColor() {
		//
	}

	public static NVGColor create() {
		return new NVGColor();
	}

	public NVGColor r(float r) {
		data[0] = r;
		return this;
	}

	public NVGColor g(float g) {
		data[1] = g;
		return this;
	}

	public NVGColor b(float b) {
		data[2] = b;
		return this;
	}
	
	public NVGColor a(float a) {
		data[3] = a;
		return this;
	}

	public float[] get() {
		return data;
	}

	public void free() {
		data = null;
	}

	public static NVGColor calloc() {
		return create();
	}
}
