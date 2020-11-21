package test;

import static org.mini.gl.GL.GL_RENDERER;
import static org.mini.gl.GL.GL_VENDOR;
import static org.mini.gl.GL.GL_VERSION;
import static org.mini.gl.GL.glGetString;

import org.mini.gui.GOpenGLPanel;
import org.mini.gui.GToolkit;
import org.mini.nanovg.Nanovg;

public class TestPane extends GOpenGLPanel {
	@Override
	public void gl_destroy() {
		//
	}

	@Override
	public void gl_init() {
        byte[] name = glGetString(GL_VENDOR);
        byte[] biaoshifu = glGetString(GL_RENDERER);
        byte[] OpenGLVersion = glGetString(GL_VERSION);
        String glVendor = new String(name);
        String glRenderer = new String(biaoshifu);
        String glVersion = new String(OpenGLVersion);
        System.out.println("Vendor : " + glVendor);
        System.out.println("Renderer : " + glRenderer);
        System.out.println("Version : " + glVersion);
	}
	
	@Override
	public boolean paint(long vg) {
		super.paint(vg);
		
		Nanovg.nvgBeginPath(vg);
		Nanovg.nvgRect(vg, 32, 32, 128, 128);
		Nanovg.nvgFillColor(vg, Nanovg.nvgRGBA((byte) 255, (byte) 0, (byte) 0, (byte) 255));
		Nanovg.nvgFill(vg);
		
		GToolkit.drawText(vg, 200, 200, 300f, 20f, "Hello World", 12f, GToolkit.getStyle().getTextFontColor());
		
		return true;
	}

	@Override
	public void gl_paint() {
		//
	}
}
