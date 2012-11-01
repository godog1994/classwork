/**
 * Exercise 1.11.  A function f is defined by the rule that f(n) = n if n<3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n> 3.
 *  Write a procedure that computes f by means of a recursive process. Write a procedure that computes f by means of an iterative process.
 *
 */
public class exercise1point11 {

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
	
	public static void main(String []args)
	{
		System.out.println(function(5));
	}
}
