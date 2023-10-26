package recursion;

public class recursionPractice1 {
	
	public static int maxOfArray(int[] arr, int max, int index) {
		if (index == arr.length)
			return max;
			
		if (arr[index] > max)
			max = arr[index];
		
		max = maxOfArray(arr,max,index+1);
		return max;
	}
	
	public static int minOfArray(int[] arr, int min, int index) {
		if (index == arr.length)
			return min;
			
		if (arr[index] < min)
			min = arr[index];
		
		min = minOfArray(arr,min,index+1);
		return min;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {5,10,12,15,20,2,5};
		int max = maxOfArray(arr,0,0);
		System.out.println("Maximum of the array = "+max);
		int min = minOfArray(arr,arr[0],0);
		System.out.println("Minimum of the array = "+min);
	}

}
