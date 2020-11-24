package test;

import org.mini.gui.GApplication;
import org.mini.gui.GForm;
import org.mini.gui.GLanguage;

import lwjgui.scene.Scene;

public abstract class LWJGUIMobileApplication extends GApplication {
	LWJGUIForm form;
	
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
		
        return form;
    }
}
