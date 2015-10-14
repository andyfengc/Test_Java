package andy.test.javafx;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class TreeViewSample extends Application {

    private final Node rootIcon = new ImageView(
        new Image(getClass().getResourceAsStream("folder_16.png"))
    );

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tree View Sample");        
        
//        TreeView<String> tree = createTree1();
        TreeView<String> tree2 = createTree2();
        
        StackPane root = new StackPane();
        root.getChildren().add(tree2);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

	private TreeView<String> createTree2() {
		TreeItem<String> rootItem = new TreeItem<String>("Inbox", rootIcon);
		rootItem.setExpanded(true);
		TreeView<String> tree = new TreeView<>();
		tree.setRoot(rootItem);
		for (int i = 0; i < 6; i++){
			TreeItem<String> item = new TreeItem<String>("Message" + i +":");
			rootItem.getChildren().add(item);
		}
		return tree;
	}

	public TreeView<String> createTree1() {
		TreeItem<String> rootItem = new TreeItem<String> ("Inbox", rootIcon);
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);            
            rootItem.getChildren().add(item);
        }        
        TreeView<String> tree = new TreeView<String> (rootItem);
		return tree;
	}
}
