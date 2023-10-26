import java.util.*;
public class Assignment4_Q2 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int size;
		System.out.println("Enter the size of the list");
		size= in.nextInt();
		int list[] = new int[size];
		for (int i=0;i<size;i++)
		{
			System.out.println("Enter the "+i+"th element of the list");
			list[i] = in.nextInt();
		}
		
		bubbleSort sort = new bubbleSort();
		list = sort.bubblesort(list);
		
		for (int i=0;i<list.length;i++)
		{
			System.out.println("In position "+i+"element is "+list[i]);
		}
	}
}
