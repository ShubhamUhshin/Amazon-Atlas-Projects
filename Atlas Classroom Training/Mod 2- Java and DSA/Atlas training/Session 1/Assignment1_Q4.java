import java.util.Scanner;
public class Assignment1_Q4
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int value;
		System.out.println("1 for bike");
		System.out.println("2 for auto");
		System.out.println("3 for cab");
		System.out.println("Enter your choice");
		value = in.nextInt();
		
		if (value == 1)
			System.out.println("Your bike is on the way");
		else if(value == 2)
			System.out.println("Your auto is on the way");
		else if(value == 3)
		{
			int cabvalue;
			
			System.out.println("1 for mini");
			System.out.println("2 for prime");
			System.out.println("3 for sedan");
			System.out.println("Enter your choice");
			cabvalue = in.nextInt();
			
			if (cabvalue == 1)
				System.out.println("Your mini is on the way");
			else if(cabvalue == 2)
				System.out.println("Your prime is on the way");
			else if(cabvalue == 3)
				System.out.println("Your Sedan is on the way");
		}
	}
}
