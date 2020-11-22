package org.lwjgl.nanovg;

import org.lwjgl.system.MemoryStack;

public class NVGGlyphPosition {
	private float x1;
	private float x2;
	
	public static class Buffer {
		private int size;
		private int index;
		private NVGGlyphPosition[] data;
		
		public Buffer(int size) {
			this.size = size;
			this.data = new NVGGlyphPosition[size];
		}
		
		public int size() {
			return this.size;
		}

		public NVGGlyphPosition get() {
			return data[index++];
		}

		public void put(NVGGlyphPosition glyph) {
			data[index++] = glyph;
		}
		
		public void flip() {
			index = 0;
		}
	}

	public NVGGlyphPosition(float x1, float x2) {
		this.x1 = x1;
		this.x2 = x2;
	}

	public static Buffer mallocStack(int length, MemoryStack stack) {
		return new Buffer(length);
	}

	public float x() {
		return this.x1;
	}

	public float maxx() {
		return this.x2;
	}
}
