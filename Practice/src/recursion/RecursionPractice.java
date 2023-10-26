package recursion;

public class RecursionPractice {
	
	public static void sumOfWholeNumbers(int number, int sum) {
		if (number == 1) {
			System.out.println("Sum of whole number is "+(sum+1));
			return;
		}
		
		sum = sum + number;
		sumOfWholeNumbers(number-1,sum);
	}
	
	public static int sumOfWholeNumbers1(int currentNumber, int number, int sum){
		if (currentNumber == number) {
			return sum;
		}
		
		sum=sum+currentNumber;
		sum = sumOfWholeNumbers1(currentNumber+1,number,sum);
		return sum;
	}
	
	public static int countFactors(int number, int divisor, int count) {
		if (divisor==0)
			return count;
		
		if (number%divisor == 0) {
			count++;
		}
		count = countFactors(number, divisor-1,count);
		return count;
	}
	public static void sumOfTen(int number, int sum) {
		if (number==0) {
			System.out.println("sum of 10 natural numbers= "+sum);
			return;
		}
		
		sum = sum+number;
		sumOfTen(number-1,sum);
		System.out.println(number+" iteration "+sum);
	}
	
	public static void main(String args[]) {
		sumOfTen(10,0);
		System.out.println("Happy Birthday Aman");
		//int number = 10;
		//System.out.println("using int method "+sumOfWholeNumbers1(0,number,0));
		//sumOfWholeNumbers(number-1,0);
		//System.out.println("using int method "+countFactors(number,number,0));
	}
}
