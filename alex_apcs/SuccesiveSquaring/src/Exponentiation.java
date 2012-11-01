
public class Exponentiation
{
	
	
	public static double powerUsingSquaring(double base, double power)
	{
		if (power < 0)
		{
			power = -power;
		}
		
		else if (power ==0)
		{
			return 1;
		}
		else if (power ==1)
		{
			return base;
		}
		else if (power==2)
		{
			return power*power;
		}
		
		else if (power%2 == 0)
		{
			return powerUsingSquaring(powerUsingSquaring(base, power / 2), 2);
		}
		
		return powerUsingSquaring(base, (power - 1)) * base;
		
		
	}
	public static void main(String []args)
	{
		double a = 4, b =0 ; //
		double pow = powerUsingSquaring(a, b);
		if (b < 0) {
		pow = 1 / pow;
		}
		System.out.println(a +  "to the power of" + b +  " ="  + pow);
		}
	}

