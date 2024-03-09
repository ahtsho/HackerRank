package multithreading;

public class HiHelloInterleavingNameNPriority {

	public static void showThreadinfo(Thread t) {
		System.out.println("THREAD INFO [name: "+t.getName()+", id: "+t.getId()+", is alive: "+t.isAlive() +", has priority: "+t.getPriority()+"]");
	} 
	
	public static void main(String[] args) throws Exception {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+": \"Hi\" ");
				try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
			}
		});
		

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+": \"Hello\" ");
				try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
			}
		}, "Second Thread");
		
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		
		showThreadinfo(t1);
		
		System.out.println("N° threads in group = "+Thread.activeCount());
		
		// try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace();}
		
		t2.start();
		t2.setPriority(Thread.MIN_PRIORITY);
		showThreadinfo(t2);
		
		System.out.println("N° threads in group = "+Thread.activeCount());
		
		t1.join(); // main thread waits for t1 to die
		t2.join(); // main thread waits for t2 to die
		
		showThreadinfo(t1);
		showThreadinfo(t2);
		System.out.println("N° threads in group = "+Thread.activeCount());
		System.out.println("Bye");
	}

}
