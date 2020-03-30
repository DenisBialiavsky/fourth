package concurrency;

public class LifeCycle {

	public LifeCycle() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String...ds) throws InterruptedException {
		Thread th = new NewThread();
		th.start();
		th.setPriority(10);
		th.join();
		//Thread.yield();
		//Thread.sleep(3000);
		System.out.println(Thread.currentThread().getName());
	}
	
	
	
}

class NewThread extends Thread{
	
	
	
	public void run() {
		System.out.println("New thread");
	}
}
