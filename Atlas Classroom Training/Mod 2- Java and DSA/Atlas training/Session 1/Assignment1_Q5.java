public class Assignment1_Q5 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 		char white = '\u25A1';
		 		char black = '\u25A0';
				int i,j;
				for (i=1;i<=8;i++)
				{
					for (j=1;j<=4;j++)
					{
						if (i%2==0)
							System.out.print(black+" "+white+" ");
						else
							System.out.print(white+" "+black+" ");
					}
					System.out.println();
				}
			
	}
}