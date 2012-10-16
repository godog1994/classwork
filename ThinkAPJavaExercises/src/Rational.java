
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
	
	public void printRational(Rational r)
	{
		System.out.println("The numerator is " + r.numerator + " the denominator is " + r.denominator + ".");
	}
	
	public static void main(String []args)
	{
		Rational r = new Rational(6,3);
		
		r.printRational(r);
	}
	

}
