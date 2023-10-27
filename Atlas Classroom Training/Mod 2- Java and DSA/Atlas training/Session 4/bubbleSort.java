// This class is written for Assignment 4 Question 2

public class bubbleSort 
{
	
	public int[] bubblesort(int[] list)
	{
		int i,j,temp;
		for (i=0;i<list.length;i++)
		{
			for (j=0;j<list.length-1-i;j++)
			{
				if (list[j]>list[j+1])
				{
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		return list;
	}
}
