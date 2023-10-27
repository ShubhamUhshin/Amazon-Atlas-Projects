import java.util.Arrays;

public class MergeSortApp {

	
	static void merge(int[] array, int left, int middle, int right) {
		
		System.out.println("[merge] left: "+left+" middle: "+middle+" right: "+right);
	}
	
	// Divide the Array till Individual Elements
	static void mergeSort(int[] array, int left, int right) {
		
		System.out.println("[mergeSort] left: "+left+" right: "+right);
		
		if(left < right) {
			
			for(int idx=left;idx<=right;idx++) {
				System.out.print(array[idx]+" ");
			}
			System.out.println();
			
			int middle = (left+right)/2;
			System.out.println("[mergeSort] middle: "+middle);
			System.out.println("`````````````````````````````");
			System.out.println();
			
			mergeSort(array, left, middle); 		// Dividing the Array in the LEFT => Left Sub Arrays
			mergeSort(array, middle+1, right);		// Dividing the Array in the RIGHT => Right Sub Arrays
		
			merge(array, left, middle, right);
		}
	}

	
	public static void main(String[] args) {
		
		int[] productPrices = {1200, 1100, 3500, 500, 350, 1900};
		System.out.println("[main] Initial Array: "+Arrays.toString(productPrices));
		System.out.println();

		//System.out.println("Product Prices Before: ");
		//printArray(productPrices);
		
		
		mergeSort(productPrices, 0, productPrices.length-1);
		
		
		//System.out.println("Product Prices After: ");
		//printArray(productPrices);
	}

}
