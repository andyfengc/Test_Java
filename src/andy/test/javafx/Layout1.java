package andy.test.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Layout1 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(20));
		
		Rectangle rect1 = new Rectangle(10, 10);
		Rectangle rect2 = new Rectangle(50, 50);
		
		hbox.getChildren().addAll(rect1, rect2);
		
		Scene scene =  new Scene(hbox, 800, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// start another thread
		Button btn = new Button("start thread 1");
		hbox.getChildren().add(btn);
		btn.setOnAction((e) -> {
			Thread newThread = new Thread(new Task<Integer>() {

				@Override
				protected Integer call() throws Exception {
					// way1, cross thread exception handler
//					Platform.runLater(new Runnable() {
//						public void run() {
//							throw new RuntimeException("bbb");
//						}
//					});
					
					// way2, cross thread exception handler 
					Layout1.handlerCrossThreadException(new RuntimeException("bbb") );
					
					// display random number
//					for(int i=0;i<Integer.MAX_VALUE;i++){
//						System.out.println(i);
//						Thread.sleep(500);
//					}
					return null;
				}
			});
			newThread.setUncaughtExceptionHandler(new Layout1().new UncaughtExceptionHandler());
			newThread.start();;
		});
		
 		// start another thread
				Button btn2 = new Button("start thread 2");
				hbox.getChildren().add(btn2);
				btn2.setOnAction((e) -> {
					System.out.println("aaa");
					
				});
		Thread.setDefaultUncaughtExceptionHandler(new Layout1().new UncaughtExceptionHandler());
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
		
	}
	
	class UncaughtExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println(e);
		}		
	}
	
	static void handlerCrossThreadException(Exception e){
		ThreadExceptionHandler.handle(e);
	}
	 
}
