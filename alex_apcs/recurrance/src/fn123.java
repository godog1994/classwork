//compute f(n) = a*
public class fn123 {
static int a,b,c,f0,f1,f2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a =1;
		b=1;
		c=1;
		f0=1;
		f1=1;
		f2=1;
		
		System.out.println(computef123abc(a,b,c,5,f0,f1,f2));
		System.out.println(iterVersion(5));
	}
	public static int computef123abc(int a, int b, int c, int n, int f0, int f1, int f2)
	{
		int retval = 0;
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
		retval = computef123abc(a, b, c, n-1, f0, f1, f2);
		retval = computef123abc(a, b, c, n-2, f0, f1, f2);
		retval = computef123abc(a, b, c, n-3, f0, f1, f2);
		
		return retval;
	}
	
	public static int iterVersion(int n)
	{
		//int retval = 0; use fi when i = n
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
		
		int fim1 = f2;
		int fim2 = f1;
		int fim3 = f0;
		int fi = 0;
		for (int i =3; i <n+1;i++)
		{
			fi = a*fim1 + b*fim2 + c*fim3;
			
			fim3 = fim2;
			fim2 = fim1;
			fim1 = fi;
			
		}
		return fi;
	}

}
