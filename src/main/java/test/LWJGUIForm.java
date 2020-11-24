package test;

import org.lwjgl.glfw.GLFW;
import org.mini.glfm.Glfm;
import org.mini.gui.GForm;
import org.mini.gui.GObject;
import org.mini.gui.event.GActionListener;

import lwjgui.LWJGUIUtil;
import lwjgui.paint.Color;
import lwjgui.scene.Scene;
import lwjgui.scene.Window;
import lwjgui.scene.WindowManager;
import lwjgui.scene.control.Label;
import lwjgui.scene.layout.StackPane;
import lwjgui.style.BackgroundLinearGradient;
import lwjgui.style.BoxShadow;

public class LWJGUIForm extends GForm {
	private Window window;
	
	public LWJGUIForm() {
		super();
		
		// Create (fake) GLFW window. Wrap to LWJGUI window
		window = WindowManager.generateWindow(0);
		
		// Get scene
		Scene scene = window.getScene();
		StackPane root = (StackPane) scene.getRoot();
		
		// Test
		StackPane t = new StackPane();
		t.getClassList().add("test-button");
		root.getChildren().add(t);
		
		t.setStylesheet(""
				+ ".test-button {"
				+ "		background-color:yellow;"
				+ "		border-radius:8px;"
				+ "		width:128px;"
				+ "		height:128px;"
				+ "		box-shadow:12px 12px 32px;"
				+ "}"
				+ ""
				+ ".test-button:active {"
				+ "		background-color:orange;"
				+ "}"
				+ "");

		// Set Scene data
		Label testLabel = new Label("Hello World");
		t.getChildren().add(testLabel);
		
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
    
    private boolean touched;

    @Override
    public void touchEvent(int touchid, int phase, int x, int y) {
    	window.getCursorPosCallback().invoke(window.getID(), x, y);
    	if ( phase == Glfm.GLFMTouchPhaseBegan && !touched ) {
    		touched = true;
    		window.getMouseButtonCallback().invoke(window.getID(), GLFW.GLFW_MOUSE_BUTTON_LEFT, 1, 0);
    	}    	
    	
    	if ( phase == Glfm.GLFMTouchPhaseEnded && touched ) {
    		touched = false;
    		window.getMouseButtonCallback().invoke(window.getID(), GLFW.GLFW_MOUSE_BUTTON_LEFT, 0, 0);
    	}
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

		LWJGUIUtil.fillRect(window.getContext(), window.getMouseHandler().getX()-4, window.getMouseHandler().getY()-4, 8, 8, Color.RED);
		
		// Force flush
		GForm.flush();
		return true;
	}
}
