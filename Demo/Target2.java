
/********************************************************
 * An example source module to accompany...
 *
 * Amir Eaman
 */package Demo;



public class Target2 {

	private ThreadLocal tl = new ThreadLocal();// a potential solution to stateless classes!!
	int i;
	public  void a() 
	{ 		
						
        i++;
		 System.out.println("This thread ID is " + Thread.currentThread().getId());
	 	System.out.println(i);
	    tl.set(Thread.currentThread().getId()); 	
	    b();	
	}
	
	public  void b() 
	{ 		
		System.out.println("The value inside Threadlocal for this thread is: " + tl.get());
	}
	
	public static void main(String[] args){
		
		Target2 tg2 = new Target2();
		Thread threadF = new Thread()
		{
			
			public void run()
			{
				tg2.a();				
			}
					
		};
		
		Thread threadS = new Thread()
		{		
			public void run()
			{
				tg2.a();				
			}					
		};
		threadF.start();
		threadS.start();		
	}
	
}