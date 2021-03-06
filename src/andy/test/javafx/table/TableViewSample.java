package andy.test.javafx.table;
/**
 * a table framework
 */
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewSample extends Application {

	private TableView table = new TableView();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Table View Sample");
		stage.setWidth(300);
		stage.setHeight(500);

		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		TableColumn firstNameCol = new TableColumn("First Name");
		TableColumn lastNameCol = new TableColumn("Last Name");
		TableColumn emailCol = new TableColumn("Email");

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);

		// nested column
		TableColumn firstEmailCol = new TableColumn("Primary");
		TableColumn secondEmailCol = new TableColumn("Secondary");
		emailCol.getColumns().addAll(firstEmailCol, secondEmailCol);

		stage.show();
	}
	
	
	public static class Person {
	    private final SimpleStringProperty firstName;
	    private final SimpleStringProperty lastName;
	    private final SimpleStringProperty email;
	 
	    private Person(String fName, String lName, String email) {
	        this.firstName = new SimpleStringProperty(fName);
	        this.lastName = new SimpleStringProperty(lName);
	        this.email = new SimpleStringProperty(email);
	    }
	 
	    public String getFirstName() {
	        return firstName.get();
	    }
	    public void setFirstName(String fName) {
	        firstName.set(fName);
	    }
	        
	    public String getLastName() {
	        return lastName.get();
	    }
	    public void setLastName(String fName) {
	        lastName.set(fName);
	    }
	    
	    public String getEmail() {
	        return email.get();
	    }
	    public void setEmail(String fName) {
	        email.set(fName);
	    }
	        
	}
}