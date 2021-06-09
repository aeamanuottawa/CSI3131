package Demo;

import java.util.concurrent.locks.*;

class WaterTank extends Thread {
	
	    private static Lock WaterTankLock = new ReentrantLock();

	    private static int watertanklevel=0;
	    private static Condition empty = WaterTankLock.newCondition();

  
	    public static void useWaterTank() {
	     	WaterTankLock.lock();
        	try { while ( watertanklevel < 40) 
        	         { 
                 System.out.format("Thirsty Person %s is still thirsty... waiting by putting the water tank lock back.\n", Thread.currentThread().getName());
                 empty.await();
                        }
        	
        	watertanklevel -=40;
        	System.out.format("Thirsty person %s is drinking water -40. Now Left  %d \n", Thread.currentThread().getName(), watertanklevel);
        
	    }
        	catch (Exception e) {
                e.printStackTrace();
            }
        	finally {
        		
        		WaterTankLock.unlock();        		
        	}      	
	    }
        	   
	    public static void fillWaterTank() {
        	WaterTankLock.lock();
            	
        	watertanklevel+=60;
        	System.out.format("Refilled +60.. by Filler %s. The water level is %d \n" ,Thread.currentThread().getName(),watertanklevel);
        	empty.notifyAll();

            WaterTankLock.unlock();                 
	    }
	}

public class ConditionalVariableDEMO {
	    public static void main(String args[]) {
	    
	    	for(int i=4;i<10;i++)
	    	new Thread(() -> { WaterTank.useWaterTank();}, Integer.toString(i)).start();
 	
	    	for(int i=0;i<4;i++)
	    	new Thread(() -> { WaterTank.fillWaterTank();}, Integer.toString(i)).start();	               	
	    }
	}
