package mobile.lwjgui;

import org.mini.gui.GCallBack;

import lwjgui.collections.ObservableList;
import lwjgui.font.Font;
import lwjgui.font.FontStyle;
import lwjgui.geometry.Insets;
import lwjgui.geometry.Pos;
import lwjgui.paint.Color;
import lwjgui.scene.control.Button;
import lwjgui.scene.control.PopupWindow;
import lwjgui.scene.layout.HBox;
import lwjgui.scene.layout.Pane;
import lwjgui.scene.layout.StackPane;
import lwjgui.scene.layout.VBox;
import lwjgui.style.BoxShadow;
import lwjgui.style.Percentage;

public class AlertBase extends PopupWindow {
	
	private Pane alertPane;
	
	private Pane body;
	
	private HBox buttonPane;

	private ObservableList<AlertButton> buttons;
	
	public AlertBase() {
		this.setPrefSize(GCallBack.getInstance().getDeviceWidth(), GCallBack.getInstance().getDeviceHeight());
		this.setBackgroundLegacy(Color.DARK_GRAY.alpha(0.4f));
		
		float width = (float) (Math.min(this.getPrefWidth(), this.getPrefHeight())) * 0.8f;
		
		this.alertPane = new VBox();
		((VBox)this.alertPane).setSpacing(0);
		this.alertPane.setPrefSize(width, 16);
		this.alertPane.getBoxShadowList().add(new BoxShadow(16, 16, 48, 0.33f));
		this.alertPane.setMaxWidth(width);
		this.alertPane.setStylesheet(""
				+ ".alert-button {"
				+ "		background-color: rgb(235, 235, 235);"
				+ "		border-color: SILVER;"
				+ "		padding:16px;"
				+ "		color:aqua;"
				+ "}"
				+ ".alert-body {"
				+ "		background-color: rgb(235, 235, 235);"
				+ "		border-color: SILVER;"
				+ "		padding:16px;"
				+ "		border-bottom:1px;"
				+ "		border-style:solid;"
				+ "}"
				+ "");
		
		this.getChildren().add(alertPane);
		
		this.body = new StackPane();
		this.body.setAlignment(Pos.CENTER);
		this.body.setBorderRadii(16, 16, 0, 0);
		this.body.setPrefWidthRatio(new Percentage(100));
		this.setBorderColor(Color.LIGHT_GRAY);
		this.body.getClassList().add("alert-body");
		this.alertPane.getChildren().add(body);
		
		this.buttonPane = new HBox();
		this.buttonPane.setSpacing(0);
		this.buttonPane.setAlignment(Pos.CENTER);
		this.buttonPane.setPrefWidthRatio(new Percentage(100));
		this.alertPane.getChildren().add(buttonPane);
		
		this.buttons = new ObservableList<>();
		this.buttons.setAddCallback((element)->{
			Button button = new Button(element.label);
			this.buttonPane.getChildren().add(button);
			element.backedButton = button;
			
			button.setFontStyle(FontStyle.BOLD);
			button.setFont(Font.SEGOE);
			
			button.getClassList().add("alert-button");
			button.setOnAction((event)->{
				element.callback.run();
			});
			
			for (int i = 0; i < this.buttons.size(); i++) {
				AlertButton b = this.buttons.get(i);
				b.backedButton.setPrefWidth(width/(float)this.buttons.size());
				if ( i == 0 )
					b.backedButton.setBorderRadii(0, 0, 0, 16);
				else if ( i == this.buttons.size()-1 )
					b.backedButton.setBorderRadii(0, 0, 16, 0);
				else
					b.backedButton.setBorderRadii(0, 0, 0, 0);
				
				if ( i < this.buttons.size()-1 )
					b.backedButton.setBorder(new Insets(0, 1, 0, 0));
				else
					b.backedButton.setBorder(new Insets(0, 0, 0, 0));
					
			}
		});
		this.buttons.setRemoveCallback((element)->{
			Button b = element.backedButton;
			if ( b == null )
				return;
			
			this.buttonPane.getChildren().remove(b);
			element.backedButton = null;
		});
	}
	
	public Pane getBody() {
		return this.body;
	}
	
	public ObservableList<AlertButton> getButtons() {
		return this.buttons;
	}
	
	public static class AlertButton {
		private String label;
		private Runnable callback;
		private Button backedButton;
		
		public AlertButton(String label, Runnable callback) {
			this.label = label;
			this.callback = callback;
		}
	}
}
