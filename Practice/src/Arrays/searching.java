package Arrays;

public class searching {
	public static boolean linearSearch(int[] array, int searchElement) {
		
		// linearly array ke har ek element -> searchElement ke saath compare
		boolean found = false;
		for (int i=0; i<array.length; i++) {
			if (array[i] == searchElement) {
				found = true;
				break;
			}
		}
		return found;
	}
	
public static int linearSearchFrequency(int[] array, int searchElement) {
		
		int frequency = 0;
		for (int i=0; i<array.length; i++) {
			if (array[i] == searchElement)
				frequency++;
		}
		
		return frequency;
	}

	public static void main(String args[]) {
		int array[] = {1,2,3,2,2};
		int searchElement = 2;
		
		boolean found;
		found = linearSearch(array,searchElement);
		System.out.println(found);
		
		System.out.println("Frequency of "+searchElement+" is "+linearSearchFrequency(array,searchElement));
		
	}
}
