package recursion;
// number = 4
// 4*3*2*1
/*
factorial - 120 = 5*4*3*2 
- 5 * 24
- 5 * 4 * 6
- 5 * 4 * 3 * 2
*/
public class factorialUsingRecursion {
	
	public static int factorial (int number) {
		if (number == 0)
			return 1;
		
		return number*factorial(number-1);
	}
	public static void main(String args[]) {
		int number = 5;
		int factorial1 = 1;
		while (number!=0) {
			factorial1 = factorial1 * number;
			number--;
		}
		
		System.out.println("factorial using loop is "+factorial1);
		System.out.println("factorial using recursion is "+factorial(5));
	}

}
