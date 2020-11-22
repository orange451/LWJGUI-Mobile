package org.lwjgl.nanovg;

import org.mini.nanovg.Nanovg;

public class NanoVGGL2 {

	public static final int NVG_STENCIL_STROKES = Nanovg.NVG_STENCIL_STROKES;
	public static final int NVG_ANTIALIAS = Nanovg.NVG_ANTIALIAS;

	public static int nvglCreateImageFromHandle(long nvg, int texId, int width, int height, int nvgImageFlipy) {
		return NanoVGGL3.nvglCreateImageFromHandle(nvg, texId, width, height, nvgImageFlipy);
	}

	public static long nvgCreate(int flags) {
		return Nanovg.nvgCreateGLES3(flags);
	}

	public static void nvgDelete(long nvgContext) {
		Nanovg.nvgDeleteGLES3(nvgContext);
	}

}
