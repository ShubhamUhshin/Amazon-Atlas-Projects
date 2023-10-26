/*
 *  Binary Search works on sorted Array
 *  Time Complexity of a Binary Search is O(log n)
 */


package Arrays;

public class binarySearch {
	public static boolean binarySearchFunc(int[] array, int searchElement) {
		boolean found = false;
		int middle;
		int lower = 0;
		int upper = array.length - 1;
		while (lower <= upper) {
			
			middle = (lower + upper)/2;
			
			if (array[middle] > searchElement)
				upper = middle - 1;
			
			else if (array[middle] < searchElement)
				lower = middle + 1;
			
			else {
			System.out.println("Element Mil Gaya");
			found = true;
			break;
			}
		}
		return found;
	}

	public static void main(String args[]) {
		int array[] = {5,10,15,20,25};
		System.out.println(binarySearchFunc(array,15));
		System.out.println(binarySearchFunc(array,5));
		System.out.println(binarySearchFunc(array,25));
		System.out.println(binarySearchFunc(array,35));
	}
}
