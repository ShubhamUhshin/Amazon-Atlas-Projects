import java.util.*;
public class factorial 
{
	public int fact(int n)
	{
		if (n==1)
			return 1;
		else
			return n*fact(n-1);
		
	}
	
	public static void main(Sting args[])
	{
		Scanner in =new Scanner (System.in);
		int number;
		System.out.println("Enter a number to find factorial");
		number=in.nextInt();
		factorial f = new factorial();
		int factorialOfNumber = f.fact(number);
		System.out.println("Factorial is"+factorialOfNumber);
	}
}
