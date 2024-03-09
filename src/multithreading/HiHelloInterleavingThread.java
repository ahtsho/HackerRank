package multithreading;


class Hi extends Thread {
	private void show() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Hi");
			try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void run() {
		show();
	}
}


class Hello extends Thread {
	private void show() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Hello");
			try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void run() {
		show();
	}
}

public class HiHelloInterleavingThread {
	
	public static void main(String[] args) {
		Hi hi = new Hi();
		Hello hello = new Hello();
		
		hi.start();
		try { Thread.sleep(2); } catch (InterruptedException e) {e.printStackTrace();}
		hello.start();
	}
	
	
}
