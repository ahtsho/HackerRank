package multithreading;

public class HiHelloInterleavingRunnableAnonymousLambda {

	public static void main(String[] args) throws Exception {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hi");
				try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
			}
		});
		

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello");
				try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
			}
		});
		
		t1.start();
		
		try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace();}
		
		t2.start();
		
		
		t1.join(); // main thread waits for t1 to die
		t2.join(); // main thread waits for t2 to die
		
	
		System.out.println("Bye");
	}

}
