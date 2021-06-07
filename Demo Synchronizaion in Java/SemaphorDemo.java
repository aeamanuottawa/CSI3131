package Demo;

import java.util.concurrent.*;

class SemaphorDemo extends Thread {

    private static Semaphore semaphor_order = new Semaphore(0);

  public  void methodA ()
   {
	  try {
		 semaphor_order.acquire();// decrement semaphor
			System.out.format("My name is  %s \n" ,Thread.currentThread().getName());
          System.out.print("A ");
          Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      } finally {
          System.out.println("B ");
          semaphor_order.release();//increment semaphor 
          }
   }
  
  public void methodB()
  {
	  try {
		  semaphor_order.acquire();
		  System.out.format("My name is  %s \n" ,Thread.currentThread().getName());
         System.out.print("C ");
         Thread.sleep(2000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     } finally {
         System.out.println("D ");
         semaphor_order.release();
     }
  }

    public static void main(String args[]) {   
    	new Thread(() -> {new SemaphorDemo().methodA();}, "Thread1").start();
    	new Thread(() -> {new SemaphorDemo().methodB();}, "Thread2").start();
}      

}