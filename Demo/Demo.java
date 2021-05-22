/********************************************************
 * An example source module to accompany...
 *
 * Amir Eaman
 */
package Demo;

import java.util.concurrent.*;

public class Demo implements Runnable{ // extends Thread

	private static Target target = new Target();
	
	public void run()
	{
		target.a();
		
	}
	public static void main(String[] args){
		
		//parallel a()
		Demo demo1 = new Demo(); 
		Demo demo2 = new Demo();
		// demo1.setPriority(MAX_PRIORITY);
		
	//	 demo1.start();    // extends Thread
	//	 demo2.start();
		 
		 Thread thread1 = new Thread(new Demo()); 
		 Thread thread2 = new Thread(new Demo());
		 
		 thread1.start(); // Thread one
		 thread2.start(); // Thread two
		 		 
		  System.out.println( "The main thread ID is "+Thread.currentThread().getId());
		  	
	}

	}
