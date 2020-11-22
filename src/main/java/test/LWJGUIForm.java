package test;

import org.mini.gui.GForm;

import lwjgui.scene.Scene;
import lwjgui.scene.Window;
import lwjgui.scene.WindowManager;
import lwjgui.scene.control.Label;
import lwjgui.scene.layout.StackPane;

public class LWJGUIForm extends GForm {
	private Window window;
	
	public LWJGUIForm() {
		super();
		
		// Create (fake) GLFW window. Wrap to LWJGUI window
		window = WindowManager.generateWindow(0);
		
		// Get scene
		Scene scene = window.getScene();
		StackPane root = (StackPane) scene.getRoot();

		// Set Scene data
		Label testLabel = new Label("Hello World");
		root.getChildren().add(testLabel);

		// Finalize window     
		window.show();         		
	}

	public Window getWindow() {
		return this.window;
	}
	
	@Override
	public boolean paint(long vg) {
		super.paint(vg);
		
		// Render our lwjgui window
		window.render();
		
		return true;
	}
}
