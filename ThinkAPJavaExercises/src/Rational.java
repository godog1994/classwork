/**
 * object methods better...
 * @author alexlove
 *
 */
public class Rational {
	int numerator;
	int denominator;
	int rationalNumber;
	
	public Rational()
	{
		numerator = 0;
		denominator = 0;
	}
	
	public Rational(int num, int den)
	{
		numerator = num;
		denominator = den;
	}
	
	public static void printRational(int numerator, int denominator)
	{
		System.out.println( numerator + "/" + denominator);
	}
	
	
	public static void invert(Rational r)
	{
		int holdNumerator = r.numerator;
		r.numerator = r.denominator;
		r.denominator = holdNumerator;
	}
	
	public static void negate(Rational r)
	{
		r.numerator = -r.numerator;
	}
	
	public static double toDouble(Rational r)
	{
		return ((double) r.numerator)/((double)r.denominator);
	}
	
	public static int getGCD(int x, int y)
	{
		if(y==0) return x;
		return getGCD(y, x%y);
		
	}
	
	public static void reduce(Rational r)
	{
		int d = getGCD(r.numerator, r.denominator);//what to divide by
		r.numerator = r.numerator/d;
		r.denominator = r.denominator/d;
	}
	
	public static void main(String []args)
	{
		Rational r = new Rational(3,15);
		
		printRational(r.numerator, r.denominator);
		negate(r);
		printRational(r.numerator, r.denominator);
		invert(r);
		printRational(r.numerator, r.denominator);
		System.out.println(toDouble(r));//should be -4
		reduce(r);
		printRational(r.numerator, r.denominator);
	}
	

}
