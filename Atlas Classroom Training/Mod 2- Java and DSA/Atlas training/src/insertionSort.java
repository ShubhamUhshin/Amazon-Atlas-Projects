
public class insertionSort {
	void sort(int[] array)
	{
		int i,j;
		for (i=1;i<array.length;i++)
		{
			for (j=i;j>0;j--)
			{
				if (array[j]>array[j-1])
				{
					int temp = array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
		for (i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
	}
	public static void main(String[] args)
	{
		insertionSort Sort = new insertionSort();
		int[] array= {10,5,7,2,8,31};
		for (int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		System.out.println("~~~~~~~~~~~~~~");
		Sort.sort(array);
	}

}
