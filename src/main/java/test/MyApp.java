package test;

import org.mini.gui.*;

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
        form = new GForm();
        frame = new TestPane(); // OpenGL Drawing inside
        
        // Add elements
        form.add(frame);
        form.setSize(GCallBack.getInstance().getDeviceWidth(), GCallBack.getInstance().getDeviceHeight());
        
        // Resize logic
        form.setSizeChangeListener((width, height) -> {
        	frame.setSize(width, height);
        	System.out.println("Resizing");
        });
        
        System.out.println("Created form with size:" + form.getW() + " / " + form.getH());
        form.reSize();
        return form;
    }
}
