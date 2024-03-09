package multithreading;



public class HiHelloInterleavingRunnableAnonymous {
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 5; i++) {
					System.out.println("Hi");
					try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}).start();
		
		try { Thread.sleep(2); } catch (InterruptedException e) {e.printStackTrace();}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 5; i++) {
					System.out.println("Hello");
					try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace();}
				}
				
			}
		}).start();
	}
	
	
}
