package Demo;


public class Target {

	int i =0; // ATTENTION!
	public  void a() 
	{ 		
		/*
		 * System.out.println("part1"); try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println("part2");
		 */
	 	
        i++;
		System.out.println("This thread ID is " + Thread.currentThread().getId());
	 	System.out.println(i);}
	 	
	
	
	
}