import java.io.*;
public class Assignment4_Q1 
{
	public static void main(String args[]) throws IOException
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		
		
		int size;
		System.out.println("Enter the size of the list");
		size= Integer.parseInt(in.readLine());
		int list[] = new int[size];
		for (int i=0;i<size;i++)
		{
			System.out.println("Enter the"+i+"th element of the list");
			list[i]=Integer.parseInt(in.readLine());
		}
		
		Greatest number = new Greatest();
		number.display(list);
	}

}
