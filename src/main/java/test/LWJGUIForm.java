package test;

import org.mini.gui.GCallBack;
import org.mini.gui.GForm;

import lwjgui.scene.Scene;
import lwjgui.scene.Window;
import lwjgui.scene.WindowHandle;
import lwjgui.scene.WindowManager;
import lwjgui.scene.control.Label;
import lwjgui.scene.layout.StackPane;

public class LWJGUIForm extends GForm {
	private Window window;
	
	public LWJGUIForm() {
		super();
		
		// Create fake GLFW desktop window
		// This wont actually do anything... LWJGL-MiniJVM wrapper will act as pass-through
		WindowHandle handle = WindowManager.generateHandle(GCallBack.getInstance().getDeviceWidth(), GCallBack.getInstance().getDeviceHeight(), "Window");
       
		// Wrap (fake) GLFW window to LWJGUI window
		window = WindowManager.generateWindow(handle);

		
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
