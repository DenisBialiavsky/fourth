package concurrency;

import java.io.IOException;

public class MultiThreading {

	public MultiThreading() {
	}
	
	public static void main (String ...f) {
		MyThread mth = new MyThread();
		System.out.println(Thread.currentThread().getName());
		mth.start();
		Runnable mrn = new MyRunnable();
	    Thread th = new Thread(mrn);
	    th.start();//Only start method creates a new thread
	    //contrary run method only runs code in current thread 
	    th.start();//We must not run thread which has already bean started
	    //it causes  IllegalThreadStateException
	    //instead of it we ought to create a bunch of thread objects 
	}
}

class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.print("This is the inept thred\n");	
		someMethod();
	}
	
	 void someMethod() throws RuntimeException  {
		//throw new RuntimeException();
	}
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.print("This is the futile thred\n");		
	}
}
