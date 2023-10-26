package recursion;

public class StringReverse {
	public void reverse(String word, int index) {
		if (index == 0) {
			System.out.print(word.charAt(index));
			return;
		}
		
		System.out.print(word.charAt(index));
		reverse(word,index-1);
	}
	
	public static void main(String[] args) {
		StringReverse reverser = new StringReverse();
		String word = "shubham";
		reverser.reverse(word,word.length()-1);
	}

}
