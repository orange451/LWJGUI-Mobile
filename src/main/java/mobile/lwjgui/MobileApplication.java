package mobile.lwjgui;

import org.mini.glfm.Glfm;
import org.mini.gui.GApplication;
import org.mini.gui.GCallBack;
import org.mini.gui.GForm;
import org.mini.gui.GLanguage;

import lwjgui.scene.Scene;

public abstract class MobileApplication extends GApplication {
	protected LWJGUIForm form;
	
	public abstract void start(Scene scene);

    @Override
    public GForm getForm() {
        if (form != null)
            return form;
        
        // Set the default language
        GLanguage.setCurLang(GLanguage.ID_ENG);
        
        // Setup LWJGUI
        form = new LWJGUIForm();
        
        // Add elements
		Scene scene = form.getWindow().getScene();
		start(scene);
		
		// Multi touch is best touch
		Glfm.glfmSetMultitouchEnabled(this.form.getCallBack().getDisplay(), true);
		
        return form;
    }
    
    public static void showStatusBar() {
    	Glfm.glfmSetDisplayChrome(GCallBack.getInstance().getDisplay(), Glfm.GLFMUserInterfaceChromeNavigationAndStatusBar);
    }
    
    public static void hideStatusBar() {
    	Glfm.glfmSetDisplayChrome(GCallBack.getInstance().getDisplay(), Glfm.GLFMUserInterfaceChromeFullscreen);
    }
    
    public static void showKeyboard() {
    	Glfm.glfmSetKeyboardVisible(GCallBack.getInstance().getDisplay(), true);
    }
    
    public static void hideKeyboard() {
    	Glfm.glfmSetKeyboardVisible(GCallBack.getInstance().getDisplay(), false);
    }
}
