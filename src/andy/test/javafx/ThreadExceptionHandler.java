package andy.test.javafx;

import javafx.application.Platform;

public class ThreadExceptionHandler {
	public static void handle(Exception e){
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(e);
			}
		});
	}
}
