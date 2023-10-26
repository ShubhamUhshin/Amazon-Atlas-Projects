package recursion;

public class recursionPractice2 {
	
	public static int fibonacci(int number) {
		if (number == 0)
			return 0;
		
		if (number == 1)
			return 1;
		
		return fibonacci(number - 1) + fibonacci(number - 2);
		
	}
	// time complexity n.
	public static int powerOfX(int number, int power) {
		if (power == 0) {
			if(number == 0)
				return 0;
			
			return 1;
		}
		
		if (power == 1)
			return number;
		
		return number * powerOfX(number,power-1);
	}
	
	// Time complexity log(n)
	public static int powerOfY(int number,int power) {
		if (power == 0) {
			if(number == 0)
				return 0;
			
			return 1;
		}
		if (power == 1)
			return number;
		
		return number*powerOfY(number,(power/2))*powerOfY(number,(power/2)-1);
	}
	
	public static void main(String args[]) {
		//fibonacci(0,1,10);
		//System.out.println("answer = "+powerOfY(0,0));
		
		System.out.println(fibonacci(6)); //8
		System.out.println(fibonacci(8)); //21
		System.out.println(fibonacci(40)); //102334155
	}

}
