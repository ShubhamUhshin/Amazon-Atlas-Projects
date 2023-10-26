
public class reverse {
	public static void main(String[] args) {
		
		long digit, reverse=0;
		long number = 199999999;
		
		while (number != 0) {
			digit = number % 10;
			reverse = reverse * 10 + digit;
			number = number / 10;
		}
		reverse = reverse + 9;
		int n = (int)reverse % 10;
		System.out.println(n);
		System.out.println(reverse);
	}
}
