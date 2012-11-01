
public class Squaring {
	public static int pow(int a, int b, int m)
	{
		int res = 1 % m;
		for (; b > 0; b /= 2)
		{
			if (b % 2 != 0)
				res = (res * a) % m;
			a = (a * a) % m;
		}
		return res;
	}
	public static void main(String []args)
	{
		System.out.println(pow(7,2,1000000));
	}
}
