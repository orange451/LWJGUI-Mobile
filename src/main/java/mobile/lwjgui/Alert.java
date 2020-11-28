package mobile.lwjgui;

import lwjgui.collections.ObservableList;
import lwjgui.geometry.Orientation;
import lwjgui.scene.Node;
import lwjgui.scene.Scene;
import lwjgui.scene.control.Label;

public class Alert {
	private AlertBase alertBase;
	
	public Alert(String description) {
		
		this.alertBase = new AlertBase();
		this.setBody(new Label(description));
	}

	public void show(Scene scene) {
		this.alertBase.show(scene, 0, 0);
	}
	
	public void close() {
		this.alertBase.close();
	}
	
	public ObservableList<AlertButton> getButtons() {
		return alertBase.getButtons();
	}
	
	public Node getBody() {
		return this.alertBase.getBody();
	}
	
	public void setBody(Node node) {
		this.alertBase.setBody(node);
	}

	public void setOrientation(Orientation orientation) {
		alertBase.setOrientation(orientation);
	}
	
	public Orientation getOrientation() {
		return alertBase.getOrientation();
	}
}
