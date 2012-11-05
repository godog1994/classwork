/**
 * Exercise 1.11.  A function f is defined by the rule that f(n) = n if n<3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n> 3.
 *  Write a procedure that computes f by means of a recursive process. Write a procedure that computes f by means of an iterative process.
 *
 */
public class exercise1point11 {
	static int a,b,c,f0,f1,f2;
	public static void main(String []args)
	{
	a =1;
	b=1;
	c=1;
	f0=1;
	f1=1;
	f2=1;
		System.out.println(function(5));
	}

	public static double function(double n)
		{
			if ( n < 3)
			{
				return n;
			}
			if ( n >= 3)
			{
			n = function(n-1) + 2*(function(n-2)) + 3 * (function( n-3));
			return n;
			}
			return n;
		}
	
	
}
