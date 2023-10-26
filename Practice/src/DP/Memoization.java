package DP;

import java.util.HashMap;
import java.util.Map;

public class Memoization {
	
	private Map<Integer,Integer> memoizationTable = new HashMap<>();
	public int fibonacci(int number) {
		   if(number == 0)
			   return 0;
		   if (number == 1)
			   return 1;
		   
		   if (memoizationTable.containsKey(number))
			   return memoizationTable.get(number);
		   
		   int result = fibonacci(number-1) + fibonacci(number-2); 
		   memoizationTable.put(number,result);
		   return result;
	}

	public static void main(String args[]) {
		Memoization fib = new Memoization();

		System.out.println(fib.fibonacci(6)); //8
		System.out.println(fib.fibonacci(8)); //21
		System.out.println(fib.fibonacci(40)); //102334155
		
	}
}
