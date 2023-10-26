package Arrays;
import java.util.Scanner;

public class arrayPractice {
	//WAP to input 10 numbers in an array and find the greatest.
	public void greatest(int[] array) {
		int max = 0;
		for (int i=0;i<array.length;i++) {
			if (array[i] > max)
				max = array[i];
		}
		System.out.println("Greatest in array is "+max);
	}
	
	
	//	WAP to input 10 numbers in an array and find the sum of all elements.
	//  WAP to input 10 numbers in an array and find the sum of all even elements.
	public void sum(int[] array) {
		int sum = 0;
		for (int i=0;i<array.length;i++) {
			sum += array[i];
		}
		
		System.out.println("Sum of array is "+sum);
	}
	
	//WAP to input 10 numbers in an array and find the sum of all even elements.
	public void sum1(int[] array) {
		int sum = 0;
		for (int i=0;i<array.length;i++) {
			if (array[i] % 2 ==0)
				sum += array[i];
		}
		
		System.out.println("Sum of even elements is "+sum);
	}
	
	//WAP to input n numbers in an array and find the sum of all numbers in even position.
	public void sum (int[] array, int size) {
		int sum = 0;
		for (int i=1;i<size; i++) {
			if (i % 2 == 0)
				sum += array[i];
		}
		
		System.out.println("Sum of elements in even position is "+sum);
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int [] array = new int [5];
		
		for (int i=0;i<array.length;i++) {
			System.out.println("Enter the "+i+"th element:");
			array[i] = scanner.nextInt();
		}
		
		arrayPractice practice = new arrayPractice();
		practice.greatest(array);
		practice.sum(array);
		practice.sum1(array);
		
		int size;
		System.out.println("Enter the size");
		size = scanner.nextInt();
		int[] array1 = new int [size];
		for (int i=0;i<size;i++) {
			System.out.println("Enter the "+i+"th element:");
			array1[i] = scanner.nextInt();
		}

		practice.sum(array1,size);
		
		scanner.close();
	}
}
	