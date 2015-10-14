package andy.test.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DrawCompositeShape extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane vb = new AnchorPane();
		Scene scene = new Scene(vb);
		primaryStage.setScene(scene);
		primaryStage.show();
		vb.getChildren().add(new Label("a composite shape"));
		
//		Path path = new Path();
//		MoveTo moveTo = new MoveTo(50, 50);
//		LineTo lineTo1 = new LineTo(50, 100);
//		LineTo lineTo2 = new LineTo(200, 100);
//		LineTo lineTo3 = new LineTo(200, 50);
//		LineTo lineTo4 = new LineTo(50, 50);
//		path.getElements().addAll(moveTo, lineTo1, lineTo2, lineTo3, lineTo4);
//		vb.getChildren().add(path);
		
		Rectangle rect = new Rectangle(150, 50);
		rect.setX(50);
		rect.setY(50);
//		rect.setFill(Color.YELLOW);
//		vb.getChildren().add(rect);
		
		Text text = new Text("hello");
		text.setX(100);
		text.setY(75);
//		vb.getChildren().add(text);
		
//		Shape shape1 = Shape.union(path, text);
//		vb.getChildren().add(shape1);
		
//		Shape shape2 = Shape.union(rect, text);
//		shape2.setFill(Color.YELLOW);
//		vb.getChildren().add(shape2);
		
		Canvas canvas  = new Canvas(230, 62);
		
		GraphicsContext gc= canvas.getGraphicsContext2D();
		gc.setFill(Color.YELLOW);
        gc.setStroke(Color.BLUE);
        gc.fillRect(50, 50, 200, 50);
        gc.strokeRect(50, 50, 200, 50);
		gc.strokeText("hello2", 150, 75);
		gc.fill();
		vb.getChildren().add(canvas);
	}
	
	public static void main(String[] args) {
		launch();
	}
	
	public class CustomShape extends Shape{

		@Override
		public com.sun.javafx.geom.Shape impl_configShape() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
