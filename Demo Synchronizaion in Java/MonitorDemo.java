
package Demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MonitorDemo extends Thread{
    private  boolean mailDelivered = false;
    private final static ReentrantLock lock = new ReentrantLock();

    public void checkMailbox(){
        synchronized(lock){
        	
            while(! mailDelivered){
                try { 
                	  System.out.format("%s is waiting for their mail. \n",Thread.currentThread().getName());
                lock.wait();
              
            } catch (InterruptedException e)  {
                System.out.println("Something bad happened!"); }
            }
		  System.out.format("%s is reading their mail \n",Thread.currentThread().getName());
		
        }     
    }

    public void postMan(){
        synchronized(lock){
    
        	 System.out.format("Hello from %s, I have some mails!! \n",Thread.currentThread().getName());
             this.mailDelivered = true;
            
             lock.notifyAll();
      }
    }
	
	  public static void main(String args[]) {   
		  MonitorDemo md = new MonitorDemo();
		// new Thread( () -> { md.postMan(); }, "postMan1").start();
    	new Thread( () -> { md.checkMailbox(); }, "Tenant1").start();
    	new Thread( () -> { md.checkMailbox(); }, "Tenant2").start();
    	  try { Thread.sleep(3000); } catch(Exception e) {}
		new Thread( () -> { md.postMan(); }, "postMan2").start();

	  }
	
}