package andy.test.javafx;

import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DialogTest extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Dialog test");
		FlowPane layout = new FlowPane();
		Scene scene = new Scene(layout, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

		Button btnDialog1 = new Button("Open dialog1");
		btnDialog1.setOnAction(e -> {
			System.out.println("click dialog 1");
			AlertDialog dialog = new AlertDialog();
		});

		layout.getChildren().add(btnDialog1);

	}

}

class AlertDialog {
	private Alert alert;

	public AlertDialog() {
		alert = new Alert(Alert.AlertType.INFORMATION);
		// alert.setHeaderText("test header");
		// alert.setContentText("content...");
		VBox layout = new VBox();
		layout.getChildren().add(new Label("b1"));
		layout.getChildren().add(new Button("b2"));
		TextField tf = new TextField();
		layout.getChildren().add(tf);
		TextField tf2 = new TextField();
		layout.getChildren().add(tf2);

		// add validator
		ValidationSupport validationSupport = new ValidationSupport();
//		Validator<String> validator = new Validator<String>() {
//			@Override
//			public ValidationResult apply(Control control, String value) {
//				boolean condition = value != null ? !value
//						.matches("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*")
//						: value == null;
//
//				System.out.println(condition);
//
//				return ValidationResult.fromMessageIf(control, "not a number", Severity.ERROR, condition);
//			}
//		};
		validationSupport.registerValidator(tf, Validator.createEmptyValidator("Text is required"));
//		validationSupport.registerValidator(tf, true, validator);
//		 validationSupport.validationResultProperty().addListener( (o, oldValue, newValue) ->
//         System.out.println(newValue.getMessages()));

		// alert.getDialogPane().getChildren().add(layout);
		alert.getDialogPane().setExpandableContent(layout);
		alert.getDialogPane().setExpanded(true);
		alert.showAndWait();
	}
}
