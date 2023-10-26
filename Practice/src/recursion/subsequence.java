package recursion;
public class subsequence{
	
	public static void printSubsequence(int[] arr, int index, int answer) {
		if(index == arr.length) {
			//For the empty case, it prints 0, to change that into null
			if (answer == 0)
					System.out.println("");
			else 
				System.out.println(answer);
			
			return;
		}
		
		//System.out.println(answer*10+arr[index]);
		printSubsequence(arr, index+1, answer*10+arr[index]);
		printSubsequence(arr, index+1, answer);
		
		
	}
	
	public void subsequenceFinder(String word, String answer, int index) {
		if (index == word.length()) {
			System.out.println(answer);
			return;
		}
		
		subsequenceFinder(word,answer+word.charAt(index),index+1);
		subsequenceFinder(word,answer,index+1);
			
	}
	
	public static void main(String args[]) {
		int[] arr = {1,1,3};
		printSubsequence(arr, 0,0);
		
		String word = "abc";
		subsequence subFinder = new subsequence();
		subFinder.subsequenceFinder(word, "", 0);
	}
}