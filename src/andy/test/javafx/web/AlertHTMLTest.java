package andy.test.javafx.web;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class AlertHTMLTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Show Alert");
        button.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("This is an alert!");
            WebView webView = new WebView();
            webView.getEngine().loadContent("<html>Pay attention, there are <b>HTML</b> tags, here.</html>");
            webView.setPrefSize(150, 60);
            alert.getDialogPane().setContent(webView);;
            alert.showAndWait();
        });

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 350, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}