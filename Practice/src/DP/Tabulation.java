package DP;
// WAP to find the nth term of fibonacci series
public class Tabulation {
	
	public int fibonacci(int n) {
		
		int[] table = new int [n+1];
		table [0] = 0;
		table [1] = 1;
		
		for (int i=2;i<=n;i++) {
			table[i] = table[i-1] + table[i-2];
		}

		return table[n];
	}

	public static void main(String args[]) {
		Tabulation tabulation = new Tabulation();
		System.out.println(tabulation.fibonacci(6)); //8
		System.out.println(tabulation.fibonacci(8)); //21
		System.out.println(tabulation.fibonacci(40)); //102334155
	}
}
