package andy.test.javafx.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.Group;

public class PieChartSample extends Application {
	private Label caption = new Label("test text");

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Imported Fruits");
		stage.setWidth(500);
		stage.setHeight(500);

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Grapefruit",
				13), new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10), new PieChart.Data("Pears", 22),
				new PieChart.Data("Apples", 30));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Imported Fruits");

		((Group) scene.getRoot()).getChildren().add(chart);
		stage.setScene(scene);
		stage.show();

		caption.setTextFill(Color.DARKORANGE);
		caption.setStyle("-fx-font: 24 arial;");
		((Group) scene.getRoot()).getChildren().add(caption);

		registerListener(chart);
	}

	private void registerListener(PieChart chart) {
		for (PieChart.Data data : chart.getData()) {
			// way1
//			data.getNode().setOnMouseClicked((event) ->{
//				System.out.println("click");
//				caption.setTranslateX(event.getSceneX());
//				caption.setTranslateY(event.getSceneY());
//				caption.setText(data.getPieValue() + "");
//			});
//			data.getNode().setOnMouseEntered(new EventHandler<MouseEvent>() {
//
//				@Override
//				public void handle(MouseEvent event) {
//					caption.setTranslateX(event.getSceneX());
//					caption.setTranslateY(event.getSceneY());
//					caption.setText(data.getPieValue() + "");
//				}
//			});
			// way 2.1
			data.getNode().addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
				System.out.println("click");
				caption.setTranslateX(e.getSceneX());
				caption.setTranslateY(e.getSceneY());
				caption.setText(data.getPieValue() + "");
			});

			data.getNode().addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
				caption.setTranslateX(e.getSceneX());
				caption.setTranslateY(e.getSceneY());
				caption.setText(data.getPieValue() + "");
			});
			// way 2.2
//			data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
//				System.out.println("click");
//				caption.setTranslateX(e.getSceneX());
//				caption.setTranslateY(e.getSceneY());
//				caption.setText(data.getPieValue() + "");
//			});
//
//			data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED, e -> {
//				caption.setTranslateX(e.getSceneX());
//				caption.setTranslateY(e.getSceneY());
//				caption.setText(data.getPieValue() + "");
//			});
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}