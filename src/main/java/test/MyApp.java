package test;

import static org.mini.gl.GL.GL_RENDERER;
import static org.mini.gl.GL.GL_VENDOR;
import static org.mini.gl.GL.GL_VERSION;
import static org.mini.gl.GL.glGetString;

import org.mini.glfm.Glfm;
import org.mini.gui.GForm;

import lwjgui.geometry.Pos;
import lwjgui.paint.Color;
import lwjgui.scene.Scene;
import lwjgui.scene.control.Label;
import lwjgui.scene.control.PopupWindow;
import lwjgui.scene.layout.BorderPane;
import lwjgui.scene.layout.StackPane;

public class MyApp extends LWJGUIMobileApplication {

	@Override
	public void start(Scene scene) {
		BorderPane root = new BorderPane();
		scene.setRoot(root);
		
		// Top pane
		StackPane top = new StackPane();
		top.setFillToParentWidth(true);
		top.setAlignment(Pos.BOTTOM_CENTER);
		top.setStyle(""
				+ "background-color:white;"
				+ "height:64px;"
				+ "border-color:darkgray;"
				+ "border-bottom:1px;"
				+ "box-shadow: 0px 1px 6px;"
				+ "padding: 4px;");
		root.setTop(top);
		top.getChildren().add(new Label("Top bar"));
		
		
		// Test
		StackPane t = new StackPane();
		t.getClassList().add("test-button");
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
		root.setCenter(t);
		
		t.setOnMouseClicked((event)->{
			Glfm.glfmSetKeyboardVisible(this.form.getCallBack().getDisplay(), true);
			
			PopupWindow test = new PopupWindow() {
				{
					this.setPrefSize(scene.getWidth(), scene.getHeight());
					this.setBackgroundLegacy(Color.DARK_GRAY.alpha(0.5f));
					
					this.setOnMouseClicked((event)->{
						Glfm.glfmSetKeyboardVisible(form.getCallBack().getDisplay(), false);
						this.close();
					});
				}
			};
			test.show(scene, 0, 0);
		});

		// Add text
		Label testLabel = new Label("Hello World");
		testLabel.setMouseTransparent(true);
		t.getChildren().add(testLabel);

		// Pop up
        GForm.addMessage("Hello World!");
        
        // GL Info
        byte[] name = glGetString(GL_VENDOR);
        byte[] biaoshifu = glGetString(GL_RENDERER);
        byte[] OpenGLVersion = glGetString(GL_VERSION);
        String glVendor = new String(name);
        String glRenderer = new String(biaoshifu);
        String glVersion = new String(OpenGLVersion);
        System.out.println("Vendor : " + glVendor);
        System.out.println("Renderer : " + glRenderer);
        System.out.println("Version : " + glVersion);
        
        // Top bar
        Glfm.glfmSetMultitouchEnabled(this.form.getCallBack().getDisplay(), true);
        Glfm.glfmSetDisplayChrome(this.form.getCallBack().getDisplay(), Glfm.GLFMUserInterfaceChromeNavigationAndStatusBar);
	}
}
