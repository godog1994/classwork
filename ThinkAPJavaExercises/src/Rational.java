
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
	
	public static void printRational(Rational r)
	{
		System.out.println( r.numerator + "/" + r.denominator);
	}
	
	public int getSign()
	{
		if ((numerator/denominator) > 0) //means positive sign
		{
			return 1;
		}
		else 
			return 0;//means negative sign
	}
	
	public void invert()
	{
		int holdNumerator = numerator;
		numerator = denominator;
		denominator = holdNumerator;
	}
	
	public void negate()
	{
		numerator = -numerator;
	}
	
	public double toDouble()
	{
		return (double) numerator/denominator;
	}
	
	public static int getGCD(int x, int y)
	{
		if(y==0) return x;
		return getGCD(y, x%y);
		
	}
	
	public void reduce()
	{
		int d = getGCD(numerator, denominator);//what to divide by
		numerator = numerator/d;
		denominator = denominator/d;
	}
	
	public static void main(String []args)
	{
		Rational r = new Rational(2,8);
		
		printRational(r);
		r.negate();
		printRational(r);
		r.invert();
		printRational(r);
		//System.out.println(r.toDouble());//should be -.5
		r.reduce();
		printRational(r);
	}
	

}
