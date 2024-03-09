package multithreading;

class Greetings {
	public void show(String greet) {
		for(int i = 0; i < 5; i++) {
			System.out.println(greet);
			try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}


class HiRunnable extends Greetings implements Runnable {
	public void run() {
		super.show("Hi");
	}
}


class HelloRunnable extends Greetings implements Runnable {

	public void run() {
		super.show("Hello");
	}
}

public class HiHelloInterleavingRunnable {
	
	public static void main(String[] args) {
		
		new Thread(new HiRunnable()).start();
		try { Thread.sleep(2); } catch (InterruptedException e) {e.printStackTrace();}
		new Thread(new HelloRunnable()).start();
	}
	
	
}
