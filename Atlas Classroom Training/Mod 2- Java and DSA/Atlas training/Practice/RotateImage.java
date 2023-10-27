//import java.util.Scanner;

public class RotateImage 
{
	public void rightShift(int[][] matrix) 
	{
		for(int i=0;i<matrix.length;i++)  
		{  
		//logic to reverse each row i.e 1D Array.    
			int low = 0, high = matrix.length-1;  
			while(low < high)  
			{  
				int temp = matrix[i][low];  
				matrix[i][low] = matrix[i][high];  
				matrix[i][high] = temp;  
				low++;  
				high--;  
			}  
		}
	}
	
	public void rotate(int[][] matrix)
	{
		
		int i,j;
		for (i=0;i<matrix.length;i++)
		{
			for (j=i;j<matrix.length;j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		System.out.println("After rotation");
		for (i=0;i<matrix.length;i++)
		{
			for (j=0;j<matrix.length;j++)
			{
				System.out.println(matrix[i][j]);
			}
		}
		System.out.println("Before Right Shift");
		
		rightShift(matrix);
		
		
		for (i=0;i<matrix.length;i++)
		{
			for (j=0;j<matrix.length;j++)
			{
				System.out.println(matrix[i][j]);
			}
		}
		
	}

	public static void main(String args[])
	{
		
		RotateImage Rotate = new RotateImage();
		//Scanner scanner = new Scanner(System.in);
		
		/*
		System.out.println("Enter a matrix");
		int i,j;
		int size;
		System.out.println("Enter the size of the matrix");
		size = scanner.nextInt();
		int [][] matrix = new int[n][n];
		*/
		
		int[][] matrix = new int[3][3];
		int k=1;
		System.out.println("Enter an element");
		for (int i=0;i<matrix.length;i++)
		{
			for (int j=0;j<matrix.length;j++)
			{
				matrix[i][j]=k;
				k++;
			}
		}
		Rotate.rotate(matrix);
		
	}
}
