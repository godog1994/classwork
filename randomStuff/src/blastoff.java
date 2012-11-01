
public class blastoff {

	public static void blastoff(int n)
	{
	   if (n >0)
	   {
		   
		   
		   if (n == 0)
			{
				System.out.println("blastoff");
			}
		   blastoff(n-1);
	   }
		
		
	
		
		System.out.println(n);
		
	}
	
	public static void main(String[] args)
	{
		blastoff(10);
	}
}
