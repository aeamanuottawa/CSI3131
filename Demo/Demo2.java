/********************************************************
 * An example source module to accompany...
 *
 * Amir Eaman
 */
package Demo;

public class Demo2 {
	public static void main(String[] args){
	Thread thread3 = new Thread()
	{
		
		public void run()
		{
			
			System.out.println("1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("2");
			
		}
				
	};
	Thread thread4 = new Thread()
	{		
		public void run()
		{			
			System.out.println("3");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("4");			
		}
				
	};
	
	thread3.start();
	thread4.start();
}
}