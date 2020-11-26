package mobile.lwjgui;

import lwjgui.scene.control.Label;

public class Alert extends AlertBase {
	public Alert(String description) {
		super();
		
		this.getBody().getChildren().add(new Label(description));
		
		this.getButtons().add(new AlertButton("Cancel", ()-> {
			this.close();
		}));

		this.getButtons().add(new AlertButton("OK", ()-> {
			this.close();
		}));
	}
}
