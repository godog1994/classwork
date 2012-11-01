
/**
 * Write a program to compute f(n) where
 *f(n) = a*f(n-1) + b*f(n-2) + c*f(n-3) + d*f(n-4)
 *For extra credit characterize how to solve the problem using matrix multiplication.
 * @author modified by alex love
 *
 */
public class quiz {
	static int a,b,c,d,f0,f1,f2,f3;
	
	public static void main(String []args)
	{
		a =1;
		b=1;
		c=1;
		d=1;
		f0=1;
		f1=1;
		f2=1;
		f3=1;
		System.out.println(iterVersion(5));
	}
	public static int iterVersion(int n)
	{
		
		if (n == 0)
		{
			return f0;
		}
		
		if ( n == 1)
		{
			return f1;
		}
		
		if ( n ==2 )
		{
			return f2;
		}
		if ( n ==3 )
		{
			return f3;
		}
		
		int fim1 = f3;
		int fim2 = f2;
		int fim3 = f1;
		int fim4 = f0;
		int fi = 0;
		for (int i =3; i <n+1;i++)
		{
			fi = a*fim1 + b*fim2 + c*fim3 + d*fim4;
			
			fim4= fim3;
			fim3 = fim2;
			fim2 = fim1;
			fim1 = fi;
			
		}
		return fi;
	}
	

}
