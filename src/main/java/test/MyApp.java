package test;

import org.mini.gui.*;

import lwjgui.scene.Window;
import lwjgui.scene.WindowManager;

public class MyApp extends GApplication {

    GForm form;
    GOpenGLPanel frame;

    @Override
    public GForm getForm() {
        if (form != null)
            return form;
        
        // Set the default language
        GLanguage.setCurLang(GLanguage.ID_ENG);
        
        // Create elements
        form = new LWJGUIForm();
        /*frame = new TestPane(); // OpenGL Drawing inside
        
        // Setup elements
        form.setSize(GCallBack.getInstance().getDeviceWidth(), GCallBack.getInstance().getDeviceHeight());
        frame.setSize(form.getW(), form.getH());
        form.add(frame);
        
        // Resize logic
        form.setSizeChangeListener((width, height) -> {
        	frame.setSize(width, height);
        	System.out.println("Resizing");
        });*/
        
        GForm.addMessage("Hello World!");;
        return form;
    }
}
