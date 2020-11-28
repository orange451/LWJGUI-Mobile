package test;

import static org.mini.gl.GL.GL_RENDERER;
import static org.mini.gl.GL.GL_VENDOR;
import static org.mini.gl.GL.GL_VERSION;
import static org.mini.gl.GL.glGetString;

import org.mini.gui.GCallBack;
import org.mini.gui.GForm;

import lwjgui.font.Font;
import lwjgui.font.FontStyle;
import lwjgui.geometry.Orientation;
import lwjgui.geometry.Pos;
import lwjgui.scene.Node;
import lwjgui.scene.Scene;
import lwjgui.scene.control.Label;
import lwjgui.scene.layout.BorderPane;
import lwjgui.scene.layout.StackPane;
import lwjgui.util.OperatingSystem;
import mobile.lwjgui.Alert;
import mobile.lwjgui.AlertButton;
import mobile.lwjgui.MobileApplication;

public class MyApp extends MobileApplication {

	@Override
	public void start(Scene scene) {
		// ENable status bar
		showStatusBar();
		
		// Get root pane
		BorderPane root = new BorderPane();
		scene.setRoot(root);
		
		// Top pane
		StackPane top = new StackPane();
		top.getClassList().add("top-bar");
		top.setAlignment(Pos.BOTTOM_CENTER);
		top.setStylesheet(""
				+ ".top-bar {"
				+ "		background-color:white;"
				+ "		height:12%;"
				+ "		width:100%;"
				+ "		border-color:darkgray;"
				+ "		border-bottom:2px;"
				+ "		box-shadow: 0px 1px 6px;"
				+ "		padding: 2px;"
				+ "}");
		root.setTop(top);
		
		Label text = new Label("Test App");
		text.setFont(Font.CONSOLAS);
		text.setFontStyle(FontStyle.BOLD);
		text.setStyle("font-size:30px");
		top.getChildren().add(text);
		
		
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
			Alert test = new Alert("Hello Alert");
			test.setOrientation(Orientation.HORIZONTAL);
			
			test.getButtons().add(new AlertButton("Cancel", ()-> {
				test.close();
			}));

			test.getButtons().add(new AlertButton("OK", ()-> {
				test.close();
				
				new Alert("Thank you for pressing ok!").show(scene);
			}));
			
			test.show(scene);
		});

		// Add text
		Node testLabel = new Label("Hello World");
		testLabel.setMouseTransparent(true);
		t.getChildren().add(testLabel);

		// Pop up
        GForm.addMessage("Hello World!");
        
        // GL Info
        String glVendor = new String(glGetString(GL_VENDOR));
        String glRenderer = new String(glGetString(GL_RENDERER));
        String glVersion = new String(glGetString(GL_VERSION));
        String opSystem = OperatingSystem.detect().toString();
        System.out.println("Vendor : " + glVendor);
        System.out.println("Renderer : " + glRenderer);
        System.out.println("Version : " + glVersion);
        System.out.println("Operating System : " + opSystem);
        System.out.println("Screen Size : " + GCallBack.getInstance().getDeviceWidth() + "x" + GCallBack.getInstance().getDeviceHeight());
	}
}
