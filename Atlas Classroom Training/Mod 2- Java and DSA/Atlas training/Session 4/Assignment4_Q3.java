import java.util.Scanner;
public class Assignment4_Q3 
{
	public static void main(String[] args)
	{
		Scanner in =new Scanner(System.in);
		int covidCase[][] = new int [2][5];
		int i,j;
		for (i=0;i<2;i++)
		{
			for (j=0;j<5;j++)
			{
				if (j==0)
					System.out.println("Enter the day");
				else if (j==1)
					System.out.println("Enter the month");
				else if (j==2)
					System.out.println("Enter the Active number of cases");
				else if (j==3)
					System.out.println("Enter the Number of discharged cases");
				else
					System.out.println("Enter the number of deceased");
				
				covidCase[i][j]=in.nextInt();
			}
		}
		System.out.println("Day \t Month \t Active \t Discharged \t Deceased");
		
		for (i=0;i<2;i++)
		{
			for (j=0;j<5;j++)
			{
				System.out.print(covidCase[i][j]+" \t ");
			}
			System.out.println();
		}
	}
}
