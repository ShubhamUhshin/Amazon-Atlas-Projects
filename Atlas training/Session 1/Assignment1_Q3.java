import java.util.Scanner;
public class Assignment1_Q3
{
	public static void main(String args[])
	{
		int amount;
		double gst;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter amount");
		amount= scanner.nextInt();
		
		gst = amount * 18/100;
		
		System.out.println("GST is "+gst);
	}
}
