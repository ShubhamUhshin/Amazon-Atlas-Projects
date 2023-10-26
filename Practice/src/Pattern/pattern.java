package Pattern;

public class pattern {
	/*
	 * 1
	 * 1 2
	 * 1 2 3
	 * 1 2 3 4
	 * 1 2 3 4 5
	 */
	
	public void pattern1() {
		
		System.out.println("Pattern 1:");
		for (int i = 1; i<= 5; i++) {
			for (int j = 1; j <= i; j++) 
				System.out.print(j+" ");
		
			System.out.println();
		}
		
		System.out.println("- - - - - -");
	}

	/*
	 * 1
	 * 2 1
	 * 3 2 1
	 * 4 3 2 1
	 * 5 4 3 2 1
	 */
	
	public void pattern2() {
		System.out.println("Pattern 2:");
		
		for (int i = 1; i <= 5; i++) {
			for (int j = i; j >=1; j--)
				System.out.print(j+" ");
			System.out.println();
		}
		System.out.println("- - - - - -");
	}
	
	/*
	 * 1
	 * 2 3
	 * 4 5 6
	 * 7 8 9 10
	 */
	public void pattern3() {
		
		System.out.println("Pattern 3:");
		
		int k = 1;
		for (int i = 1; i<= 4; i++) {
			for (int j = 1; j<=i; j++) {
				System.out.print(k++);
			}
			System.out.println();
		}
		
		System.out.println("- - - - - -");
	}
	
	/*
	 * 5
	 * 5 4
	 * 5 4 3
	 * 5 4 3 2
	 * 5 4 3 2 1
	 */
	public void pattern4() {
		System.out.println("Pattern 4:");
		for (int i = 5; i>=1; i--) {
			for (int j = 5; j >= i; j--)
				System.out.print(j+" ");
			System.out.println();
		}
		System.out.println("- - - - - -");
	}
	
	/*
	 * 1
	 * 1 4
	 * 1 4 9
	 * 1 4 9 16
	 * 1 4 9 16 25
	 */
	
	public void pattern5() {
		
		System.out.println("Pattern 5:");
		for (int i = 1; i<= 5; i++) {
			for (int j = 1; j <= i; j++) 
				System.out.print((j*j)+" ");
		
			System.out.println();
		}
		
		System.out.println("- - - - - -");
	}
	
	/*
	 * 1 2 3 4 5
	 * 1 2 3 4
	 * 1 2 3 
	 * 1 2 
	 * 1
	 */
	
	public void pattern6() {
		
		System.out.println("Pattern 6:");
		for (int i = 5; i>= 1; i--) {
			for (int j = 1; j <= i; j++) 
				System.out.print(j+" ");
		
			System.out.println();
		}
		
		System.out.println("- - - - - -");
	}
	
	/*
	 * 1
	 * 1 2
	 * 1 2 3
	 * 1 2 3 4
	 * 1 2 3 
	 * 1 2 
	 * 1
	 */
	
	public  void pattern7() {
		
		System.out.println("Pattern 7:");
		int n = 4;
		for (int i = 1; i <= n*2-1; i++) {
			if (i <= n)
				for (int j = 1; j <= i; j++)
					System.out.print(j+" ");
			
			else {
				for (int j=1; j <= n*2-i; j++)
					System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println("- - - - -");
	}
	
	/*
	 *    *
	 *   * *
	 *  * * *
	 * * * * *
	 *  * * *
	 *   * *
	 *    *
	 */  
	public void pattern8() {
		System.out.println("Pattern 8: ");
		int n = 7;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j < Math.ceil(n/2); j++) {
				System.out.print(" ");
			}
			
			for (int j = i; j <= n; j++)
				System.out.print("* ");
			
			System.out.println();
		}
		
	}
	public static void main (String args[]) {
		
		pattern Pattern = new pattern();
		Pattern.pattern1();
		Pattern.pattern2();
		Pattern.pattern3();
		Pattern.pattern4();
		Pattern.pattern5();
		Pattern.pattern6();
		Pattern.pattern7();
	}
}
