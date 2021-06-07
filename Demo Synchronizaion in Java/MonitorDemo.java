
package Demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MonitorDemo {
    private boolean mailDelivered = false;
    public static Lock lock = new ReentrantLock ();

    public void checkMailbox(){
        synchronized(lock){
            while(! mailDelivered){
                try { 
                	  System.out.format("%s is waiting to read their mail. \n",Thread.currentThread().getName());
                lock.wait();
            } catch (InterruptedException e)  {
                System.out.println("Something bad happened!"); }
            }
		  System.out.format("%s is reading their mail \n",Thread.currentThread().getName());
        }
      
    }

    public void postMan(){
        synchronized(lock){
        	 System.out.println("Hello from postman!");
             this.mailDelivered = true;
             lock.notifyAll();
        }
    }
	
	  public static void main(String args[]) {   
		  new Thread( () -> { new MonitorDemo().postMan(); }, "postMan").start();
    	new Thread( () -> { new MonitorDemo().checkMailbox(); }, "Tenant 1").start();
    	new Thread( () -> { new MonitorDemo().checkMailbox(); }, "Tenant 2").start();
		new Thread( () -> { new MonitorDemo().postMan(); }, "postMan").start();
		new Thread( () -> { new MonitorDemo().postMan(); }, "Tenant 3").start();
	
	  }
	
}