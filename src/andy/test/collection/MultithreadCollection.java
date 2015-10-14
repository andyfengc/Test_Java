package andy.test.collection;

import java.util.ArrayList;
import java.util.List;

public class MultithreadCollection {
	public static void main(String[] args) throws InterruptedException {
		remove();
	}

	public static void remove() throws InterruptedException {
		List<String> tickets = new ArrayList<String>();
		for (int i = 0; i < 100000; i++) {
			tickets.add("ticket NO," + i);
		}
		System.out.println("start1...");
		for (int i = 0; i < 10; i++) {
			Thread salethread = new Thread() {
				public void run() {
					while (tickets.size() > 0) {
						tickets.remove(0);
						System.out.println(Thread.currentThread().getId() + "Remove 0, size:"+tickets.size());
					}
				}
			};
			salethread.start();
		}
		System.out.println("start2...");
		new Thread() {
			public void run() {
				for (String s : tickets) {
					System.out.println(s);
				}
			}
		}.start();
	}
}
