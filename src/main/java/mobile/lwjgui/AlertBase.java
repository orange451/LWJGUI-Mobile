package mobile.lwjgui;

import org.mini.gui.GCallBack;

import lwjgui.collections.ObservableList;
import lwjgui.font.Font;
import lwjgui.font.FontStyle;
import lwjgui.geometry.Insets;
import lwjgui.geometry.Orientation;
import lwjgui.geometry.Pos;
import lwjgui.paint.Color;
import lwjgui.scene.Node;
import lwjgui.scene.control.Button;
import lwjgui.scene.control.PopupWindow;
import lwjgui.scene.layout.DirectionalBox;
import lwjgui.scene.layout.HBox;
import lwjgui.scene.layout.Pane;
import lwjgui.scene.layout.StackPane;
import lwjgui.scene.layout.VBox;
import lwjgui.style.BoxShadow;
import lwjgui.style.Percentage;
import lwjgui.transition.SizeTransition;

class AlertBase extends PopupWindow {
	
	private Pane alertPane;
	
	private Pane body;
	
	private Node innerBody;
	
	private DirectionalBox buttonPane;

	private ObservableList<AlertButton> buttons;
	
	private Orientation orientation = Orientation.HORIZONTAL;
	
	public AlertBase() {
		this.setPrefWidthRatio(new Percentage(100));
		this.setPrefHeightRatio(new Percentage(100));
		this.setBackgroundLegacy(Color.DARK_GRAY.alpha(0.4f));
		
		float width = (float) (Math.min(GCallBack.getInstance().getDeviceWidth(), GCallBack.getInstance().getDeviceHeight())) * 0.8f;
		width = Math.min(width, 350);
		
		VBox positionBox = new VBox();
		positionBox.setAlignment(Pos.CENTER);
		positionBox.setFillToParentWidth(true);
		this.getChildren().add(positionBox);
		
		Pane paddingPane = new StackPane();
		paddingPane.setFillToParentWidth(true);
		paddingPane.setPrefHeight(64);
		positionBox.getChildren().add(paddingPane);
		
		this.alertPane = new VBox();
		((VBox)this.alertPane).setSpacing(0);
		this.alertPane.setPrefSize(width, 16);
		this.alertPane.setMaxWidth(width);
		this.alertPane.getBoxShadowList().add(new BoxShadow(16, 16, 48, 0.33f));
		this.alertPane.setStylesheet(""
				+ ".alert-body {"
				+ "		background-color: rgb(235, 235, 235);"
				+ "		border-color: SILVER;"
				+ "		padding:16px;"
				+ "		border-bottom:1px;"
				+ "		border-style:solid;"
				+ "}"
				+ ".alert-button {"
				+ "		background-color: rgb(235, 235, 235);"
				+ "		border-color: SILVER;"
				+ "		padding:16px;"
				+ "		color:aqua;"
				+ "}"
				+ "");
		
		positionBox.getChildren().add(alertPane);
		
		SizeTransition transition = new SizeTransition(500l, 0, 0) {
			@Override
			protected double getCurrentWidth() {
				return paddingPane.getWidth();
			}

			@Override
			protected double getCurrentHeight() {
				return paddingPane.getHeight();
			}

			@Override
			protected void setWidth(double width) {
				//
			}

			@Override
			protected void setHeight(double height) {
				paddingPane.setPrefHeight(height);
			}
		};
		transition.play();
		
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
			if ( this.buttons.size() == 1 )
				this.buttonPane.getChildren().clear();
			
			Button button = new Button(element.getLabel());
			this.buttonPane.getChildren().add(button);
			element.setButton(button);
			
			button.setFontStyle(FontStyle.BOLD);
			button.setFont(Font.SEGOE);
			
			button.getClassList().add("alert-button");
			button.setOnAction((event)->{
				element.getCallback().run();
			});
			
			updateButtons();
		});
		this.buttons.setRemoveCallback((element)->{
			Button b = element.getButton();
			if ( b == null )
				return;
			
			this.buttonPane.getChildren().remove(b);
			element.setButton(null);
			
			checkEmptyButtons();
		});
		
		checkEmptyButtons();
	}
	
	private void checkEmptyButtons() {
		if ( this.buttons.size() > 0 )
			return;
		
		Button button = new Button("tap to dismiss");
		button.setFont(Font.SEGOE);
		button.setStyle("color:rgb(96, 96, 96); width:100%;");
		button.getClassList().add("alert-button");
		button.setOnAction((event)->{
			this.close();
		});

		this.buttonPane.getChildren().add(button);
		updateButtons();
	}
	
	private void updateButtons() {
		for (int i = 0; i < this.buttonPane.getChildren().size(); i++) {
			Node node = this.buttonPane.getChildren().get(i);
			if ( !(node instanceof Button) )
				continue;
			
			Button b = (Button)node;
			
			if ( this.orientation == Orientation.HORIZONTAL ) {
				b.setPrefWidthRatio(Percentage.fromRatio(1/(float)this.buttons.size()));
				
				float bl = 0;
				float br = 0;
				
				if ( i == 0 )
					bl = 16;
				if ( i == this.buttons.size()-1 || this.buttons.size() == 0 )
					br = 16;
				b.setBorderRadii(0, 0, br, bl);
				
				if ( i < this.buttons.size()-1 )
					b.setBorder(new Insets(0, 1, 0, 0));
				else
					b.setBorder(new Insets(0, 0, 0, 0));
			} else {
				b.setPrefWidthRatio(Percentage.ONE_HUNDRED);
		
				if ( i == this.buttons.size()-1 || this.buttons.size() == 0 )
					b.setBorderRadii(0, 0, 16, 16);
				else
					b.setBorderRadii(0, 0, 0, 0);
				
				if ( i < this.buttons.size()-1 )
					b.setBorder(new Insets(0, 0, 1, 0));
				else
					b.setBorder(new Insets(0, 0, 0, 0));
			}
		}
	}
	
	public Node getBody() {
		return this.innerBody;
	}

	public void setBody(Node body) {
		this.body.getChildren().clear();
		this.innerBody = body;
		if ( body == null )
			return;
		
		this.body.getChildren().add(body);
	}
	
	public ObservableList<AlertButton> getButtons() {
		return this.buttons;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
		
		DirectionalBox newButtonPane = null;
		if ( orientation == Orientation.VERTICAL )
			newButtonPane = new VBox();
		else
			newButtonPane = new HBox();
		
		newButtonPane.setSpacing(0);
		newButtonPane.setAlignment(Pos.CENTER);
		newButtonPane.setPrefWidthRatio(new Percentage(100));
		
		if ( this.buttonPane != null ) {
			for (Node node : this.buttonPane.getChildren())
				newButtonPane.getChildren().add(node);
			this.alertPane.getChildren().remove(this.buttonPane);
		}
		
		this.buttonPane = newButtonPane;
		this.alertPane.getChildren().add(newButtonPane);
		updateButtons();
	}
	
	public Orientation getOrientation() {
		return this.orientation;
	}
}
