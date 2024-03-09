package multithreading;

class Counter {
	public int count = 0;

	// With synch only one thread at a time can execute the method
	public synchronized void increment() {
		count++;
	}
}

public class SynchronizedMethods {

	public static void main(String[] args) throws Exception {

		Counter c = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				c.increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				c.increment();
			}
		});
		
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(c.count);
	}

}
