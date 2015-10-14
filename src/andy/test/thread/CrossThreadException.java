package andy.test.thread;

import java.util.Random;

public class CrossThreadException {
	public static void main(String[] args) {
		Random r = new Random();


		// a new thread
		Thread newThread = new Thread(new Runnable() {

			@Override
			public void run() {
				throw new RuntimeException("abc");
//				for (int i = -1; i > Integer.MIN_VALUE; i--) {
//					System.out.println(i);
//					try {
//						Thread.sleep((int)((r.nextDouble()*0.5+0.5)*1000));
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
			}
		});
		newThread.setPriority(Thread.MIN_PRIORITY);
//		newThread.setUncaughtExceptionHandler(new CrossThreadException().new UncaughtExceptionHandler());
		newThread.start();

		// main thread
		for (int i = 0; i <= Integer.MAX_VALUE; i++) {
			System.out.println(i);
			try {
				Thread.sleep((int)((r.nextDouble()*0.5+0.5)*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Thread.setDefaultUncaughtExceptionHandler(new CrossThreadException().new UncaughtExceptionHandler());
	}
	
	class UncaughtExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println(e);
		}
		
	}
}
