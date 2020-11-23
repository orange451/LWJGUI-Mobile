package test;

import org.mini.gui.GForm;

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
		t.setBackgroundLegacy(Color.ORANGE);
		t.setBorderRadii(8);
		t.setPrefSize(128, 128);
		t.getBoxShadowList().add(new BoxShadow(8, 8, 32f));
		root.getChildren().add(t);

		// Set Scene data
		Label testLabel = new Label("Hello World");
		t.getChildren().add(testLabel);
		
		this.setSizeChangeListener((width, height)-> {
			updateSize();
		});
		updateSize();

		// Finalize window     
		window.show();         		
	}
	
	private void updateSize() {
		window.setSize(this.callback.getDeviceWidth(), this.callback.getDeviceHeight());
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
		
		// Force flush
		GForm.flush();
		return true;
	}
}
