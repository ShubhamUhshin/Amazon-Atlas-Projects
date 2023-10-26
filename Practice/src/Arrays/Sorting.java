package Arrays;

import java.util.ArrayList;

public class Sorting {
	
	/*
	 *  TC = O(n*n)
	 *  SC = O(1) as we are not taking any extra variable, just the array given to us
	 *  Algo: We compare adjacent elements using a nested loop and swap them if needed.
	 *  After 1 complete inner loop iteration, the last element is in it's correct place.
	 */
	
	public void bubbleSort(int[] array) {
		
		int length = array.length;
		for (int i=0;i<length;i++) {
			for (int j=0;j<length-1-i;j++) {
				if (array[j] > array[j+1]) {
						int temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				}
			}
		}
	
	/*
	 *  TC - O(n*n)
	 *  SC - O(1)
	 *  Algo: We use nested loops to find the index of the smallest/greatest
	 *  element in the array, and swap it with the 1st element, then find
	 *  the second smallest/greatest element and swap it with the 2nd
	 *  element and so on.
	 */
	public void selectionSort(int[] array) {
		int length = array.length;
		int index;
		
		for (int i=0;i<length;i++) {
			index = i;
			
			for (int j=i+1;j<length;j++) {
				if (array[index] > array[j])
					index = j;
			}
			
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	/*
	 *  TC - O(n*n)
	 *  SC - O(1)
	 *  Algo: We are fixing an element, finding the nearest smaller
	 *  element in the right, shifting the elements to the right which
	 *  are greater than this found element, creating a pocket to insert
	 *  this element in the created position.
	 */
	public void insertionSort(int[] array) {
		
		int value;
		for (int i=1;i<array.length;i++) {
			value = array[i];
			int j = i-1;
			while (j>=0 && array[j] > value) {
				array[j+1] = array[j];
				
			/*	
				System.out.println("~~~~~~~~~~~~~~~");
				System.out.println("After swapping "+j+"th element");
				for (int k=0;k<array.length;k++) {
					
					System.out.print(array[k]+" ");
				}
			*/
				j--;
			}
			
			array[j+1] = value;
			/*
			System.out.println("~~~~~~~~~~~~~~~");
			System.out.println("After "+i+"th iteration");
			for (int k=0;k<array.length;k++) {
				
				System.out.print(array[k]+" ");
			}
			*/
		}
	}
	
	/*
	 *  TC - O(NlogN)
	 *  SC - O(1)
	 *	Algo: This sorting works on divide and conquer algorithm.
	 *	We take a pivot element, sort and place the element in it's
	 *	correct position such that all the elements in the left are
	 *	smaller than the element, and the right are greater than the
	 *	element. So, we have the array in three parts, the pivot element
	 *	is the sorted array, the left is a new unsorted array, the right
	 *	is another unsorted array.
	 *	We will then sort the arrays recursively before and after the
	 *	partition/Pivot element 
	 */
	
	// This function is pivot/Partition function for quickSort
	public int partitonQS (int[] array, int low, int high) {
		
		int i = low - 1;
		int pivot = array[high];
		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				
				i++;
				int temp = array [i];
				array [i] = array [j];
				array [j] = temp;
			}
			
		}
		
		// After the loop, the next position to the last swapped 
		// element (i) is where pivot element should be. 
		// Swapping the pivot element.
		int temp = array [i+1];
		array [i+1] = array [high];
		array [high] = temp;
		
		return (i+1);
		
	}
	
	public void quickSort(int[] array, int low, int high) {
		
		if (low < high) {
			
			int pi =  partitonQS(array, low, high);
			
			// Recursively sorting elements before and after partition
			quickSort(array, low, pi-1);
			quickSort (array,pi+1,high);
		}
	}
	
	
	/*
	 * 
	 */
	
	public void merge (int[] array, int left, int middle, int right) {
	
		ArrayList <Integer> tempArray = new ArrayList<>();
		int l = left, r = middle + 1;
		while (l <= middle && r <= right) {
			
			if (array[l] <= array[r]) {
				tempArray.add(array[l]);
				l++;
			}
			
			else {
				tempArray.add(array[r]);
				r++;
			}
		}
		
		while (l <=middle) {
			tempArray.add(array[l]);
			l++;
		}
		
		while (r <= right) {
			tempArray.add(array[r]);
			r++;
		}
		
		for (int i = left; i<=right;i++) {
			array[i] = tempArray.get(i-left);
		}
	}
	
	public void mergeSort(int[] array, int left, int right) {
		
		if (left >= right)
			return;
		
		int middle = (left + right)/2;
		
		mergeSort (array,left,middle);
		mergeSort (array,middle+1,right);
		merge(array, left, middle, right);
		
	}
	
	public void displayArray(int[] array) {
		for (int i=0; i< array.length; i++)
			System.out.print(array[i]+" ");
		
		System.out.println();
	}
	
	public static void main(String args[]) {
		Sorting sort = new Sorting();
		int[] array = {5,10,1,2,7};
		System.out.println("Before Sorting, the Array is:");
		sort.displayArray(array);
		
		// sort.bubbleSort(array);
		// sort.selectionSort(array);
		// sort.insertionSort(array);
		// sort.quickSort(array, 0, 4);
		
		sort.mergeSort(array, 0, array.length-1);
		
		System.out.println("After Sorting, the Array is:");
		sort.displayArray(array);
	}
}
