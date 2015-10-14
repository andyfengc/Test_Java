package andy.test.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DrawRectangle extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane pane = new AnchorPane();
		pane.setPrefHeight(600);
		pane.setPrefWidth(800);
		Scene scene = new Scene(pane, 600, 400);
		scene.getStylesheets().add(getClass().getResource("/andy/test/javafx/text.css").toExternalForm());

		//
		Label lbl = new Label("draw line");
		pane.getChildren().add(lbl);
		Label lbl2 = new Label("draw line2");
		pane.getChildren().add(lbl2);

		//add text
		Text txt = new Text(100, 100, "some text");
		txt.getStyleClass().add("text1");
		pane.getChildren().add(txt);
		txt.applyCss();
		double width = txt.getLayoutBounds().getWidth();
		double height = txt.getLayoutBounds().getHeight();
		//add rectangle
		Rectangle rect = new Rectangle(100, 100 - height /2, width, height);
		rect.getStyleClass().add("nodeRectangle");
		pane.getChildren().add(rect);
		
		// add line
		Line line = new Line(100+width, 100, 400, 350);
		line.getStyleClass().add("line1");
		pane.getChildren().add(line);
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}
}
