package mobile.lwjgui;

import lwjgui.scene.control.Button;

public class AlertButton {
	private String label;
	private Runnable callback;
	private Button backedButton;
	
	public AlertButton(String label, Runnable callback) {
		this.label = label;
		this.callback = callback;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public void setLabel(String string) {
		this.label = string;
	}
	
	public void setCallback(Runnable callback) {
		this.callback = callback;
	}
	
	protected Runnable getCallback() {
		return this.callback;
	}
	
	protected Button getButton() {
		return this.backedButton;
	}
	
	protected void setButton(Button button) {
		this.backedButton = button;
	}
}