import java.util.*;
public class nilay
{
	public void series()
	{
		int n=5;//Size of Arrays
		int sourceArray[]= {10,15,20,25,30};
		int destinationArray[]= {10,5,20,25,30};
		n=sourceArray.length;
		int answer[] = new int [n-1];
		int k=0;
		int i,count=1;
		for (i=0;i<n;i++)
		{
			if (sourceArray[i] == destinationArray[i])
			{
				count++;
			}
			else
			{
					answer[k]=count;
					k++;
					count=0;
			}
			
			if (i+1 == n)
			{
				answer[k]=count;
				k++;
				count=1;
			}
		}
		for (i=0;i<k;i++)
		{
			for (int j=0;j<k-1-i;j++)
			{
				if (answer[j]<answer[j+1])
				{
					int c=answer[j];
					answer[j]=answer[j+1];
					answer[j+1]=c;
				}
			}
		}
		for (i=0;i<k;i++)
		{
			System.out.println(answer[i]);
		}
	}
	public static void main(String args[]) throws Exception
	{
		nilay gandu = new nilay();
		gandu.series();
	}
}