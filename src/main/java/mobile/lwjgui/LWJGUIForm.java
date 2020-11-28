package mobile.lwjgui;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.glfw.GLFW;
import org.mini.glfm.Glfm;
import org.mini.gui.GForm;
import lwjgui.LWJGUIUtil;
import lwjgui.paint.Color;
import lwjgui.scene.Window;
import lwjgui.scene.WindowManager;

class LWJGUIForm extends GForm {
	private Window window;
	
	public LWJGUIForm() {
		super();
		
		// Create (fake) GLFW window. Wrap to LWJGUI window
		window = WindowManager.generateWindow(0);
		
		// Give it focus
		window.getWindowFocusCallback().invoke(window.getID(), true);
		
		// Resize when parent changes
		this.setSizeChangeListener((width, height)-> { updateSize(); });
		updateSize();

		// Finalize window     
		window.show();         		
	}
	
    @Override
    public void mouseButtonEvent(int button, boolean pressed, int x, int y) {
    	window.getCursorPosCallback().invoke(window.getID(), x, y);
    	window.getMouseButtonCallback().invoke(window.getID(), GLFW.GLFW_MOUSE_BUTTON_LEFT, pressed?1:0, 0);
    }
    
    private Map<Integer, TouchObject> touchedMap = new HashMap<>();;

    @Override
    public void touchEvent(int touchid, int phase, int x, int y) {
    	window.getCursorPosCallback().invoke(window.getID(), x, y);
    	
    	if ( !touchedMap.containsKey(touchid) )
    		touchedMap.put(touchid, new TouchObject());

    	touchedMap.get(touchid).x = x;
    	touchedMap.get(touchid).y = y;
    	
    	if ( touchid == 0 ) { // Only let the first touch interact with buttons
	    	if ( phase == Glfm.GLFMTouchPhaseBegan && !touchedMap.get(touchid).touched ) {
	    		touchedMap.get(touchid).touched = true;
	    		window.getMouseButtonCallback().invoke(window.getID(), GLFW.GLFW_MOUSE_BUTTON_LEFT, 1, 0);
	    	}    	
	    	
	    	if ( phase == Glfm.GLFMTouchPhaseEnded && touchedMap.get(touchid).touched ) {
	    		touchedMap.get(touchid).touched = false;
	    		window.getMouseButtonCallback().invoke(window.getID(), GLFW.GLFW_MOUSE_BUTTON_LEFT, 0, 0);
	    	}
    	}
    }
    
    private static class TouchObject {
    	float x;
    	float y;
    	boolean touched;
    }
	
	private void updateSize() {
		window.getWindowSizeCallback().invoke(window.getID(), this.callback.getDeviceWidth(), this.callback.getDeviceHeight());
		window.getFramebufferSizeCallback().invoke(window.getID(), this.callback.getFrameBufferWidth(), this.callback.getFrameBufferHeight());
	}

	public Window getWindow() {
		return this.window;
	}
	
	@Override
	public boolean paint(long vg) {
		super.paint(vg);
		
		// Render our lwjgui window
		window.render();

		LWJGUIUtil.fillRect(window.getContext(), 0, 0, window.getScene().getWidth(), window.getScene().getHeight(), Color.WHITE_SMOKE);
		
		for (TouchObject touch : touchedMap.values()) {
			if ( !touch.touched )
				continue;
			LWJGUIUtil.fillRect(window.getContext(), touch.x-4, touch.y-4, 8, 8, Color.RED);
		}
		
		// Force flush
		GForm.flush();
		return true;
	}
}
