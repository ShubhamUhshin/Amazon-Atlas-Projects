// Check if the array is sorted in ascending order

package recursion;

public class sortedArray {
	public boolean checkSorted(int[] arr, int index,boolean isSorted) {
		if (index == arr.length-1) {
			return isSorted;
		}
		
		if (arr[index] > arr[index+1])
			isSorted = true;
		
		return checkSorted(arr,index+1,isSorted);
		
	}
	public static void main(String args[]) {
		sortedArray checkArray = new sortedArray();
		int arr[] = {1,2,1,4,5};
		boolean isSorted = checkArray.checkSorted(arr,0,false);
		if (isSorted == true)
			System.out.println("Array is not sorted");
		
		else
			System.out.println("Array is sorted");
	}
}
