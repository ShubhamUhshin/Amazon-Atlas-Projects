import java.util.Scanner;

public class arraysBasic {
	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		int[] arrays = new int [5]; //Declaration
		
		for (int i=0; i<5; i++) {
			// i = 0
			// i = 1
			// i = 2
			// .
			// .
			// i = 9
			System.out.println("Enter the "+i+" element of array");
			arrays[i] = scanner.nextInt();
			// arrays [0] = INPUT
			// arrays [1] = INPUT
			// arrays[11]
		}
		
		System.out.println("Array Initialized");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		
		for (int i = 0; i< arrays.length; i++) {
			System.out.println(i+"th position "+arrays[i]);
		}
	
	scanner.close();
	}

}
