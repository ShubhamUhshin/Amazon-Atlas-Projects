import java.util.*;
import java.io.*;
public class Assignment2_Q3 
{
	
	public void divisible(int number,int count)
	{
		if (number > 0)
		{
			int d = number % 10;
			if (d == 7)
				count++;
			
			divisible((number/10),count);
		}
		
		else
		{
			System.out.println("7 is present "+count+" times");
			return;
		}
		
		return;
		
	}
	
	public static void main(String args[])
	{
		
		int number;
		int count=0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		number=in.nextInt();
		Assignment2_Q3 divisor = new Assignment2_Q3();
		divisor.divisible(number,count);
		
	}
}
