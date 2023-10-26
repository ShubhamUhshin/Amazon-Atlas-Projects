// This class is written for assignment 4 Question 1
public class Greatest 
{
	int max;
	int min;
	int sum;
	double avg;
	
	public Greatest()
	{
		max=0;
		min=0;
		sum=0;
		avg=0;
	}
	
	public void maximum(int[] list)
	{
		int i;
		int size=list.length;
		for (i=0;i<size;i++)
		{
			if (list[i]>max)
			{
				max=list[i];
			}
		}
		System.out.println("The greatest number in the list is: "+max);
	}
	
	public void minimum(int[] list)
	{
		int i;
		int size = list.length;
		min = list[0];
		for (i=0;i<size;i++)
		{
			if (list[i]<min)
			{
				min = list[i];
			}
		}
		System.out.println("The smallest number in the list is: "+min);
	}
	
	public void sumAndAverage(int[] list)
	{
		sum = 0;
		int size = list.length;
		int i;
		for (i=0;i<size;i++)
		{
			sum = sum + list[i];
		}
		
		avg = sum/size;
		
		System.out.println("Sum of the list is: "+sum);
		System.out.println("Average of the list is: "+avg);
	}
	
	public void display(int[] list)
	{
		System.out.println("The data required are:");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("The list elements are: ");
		for (int i=0;i<list.length;i++)
		{
			System.out.println("In position"+i+"element is "+list[i]);
		}
		maximum(list);
		minimum(list);
		sumAndAverage(list);
	}
}