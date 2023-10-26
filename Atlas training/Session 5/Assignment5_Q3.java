import java.util.Scanner;

public class Assignment5_Q3 
{
	public static void main(String args[])
	{
		StringCounter counter = new StringCounter();
		String string;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string");
		string=scanner.nextLine();
		scanner.close();
		
		counter.count(string);
		
	}
}
