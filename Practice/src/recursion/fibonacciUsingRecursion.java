package recursion;
// WAP to find the nth term in the fibonacci series

public class fibonacciUsingRecursion {
	
	public int fibonacci(int number) {
		   if(number == 0)
			   return 0;
		   if (number == 1)
			   return 1;
		 
		   return fibonacci(number-1) + fibonacci(number-2);   
	}
	
	public int sum(int number) {
		   if(number == 0)
			   return 0;
		   if (number == 1)
			   return 1;
		 
		   return sum(number-1) + sum(number-2);   
	}
	
	public static void main(String args[]) {
		fibonacciUsingRecursion fib = new fibonacciUsingRecursion();

		System.out.println(fib.fibonacci(6)); 
		System.out.println(fib.fibonacci(8));
		System.out.println(fib.fibonacci(40)); 
		
	}

}
