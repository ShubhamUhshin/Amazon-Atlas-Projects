// Print all unique subsequences
//Need to be worked on
package recursion;

public class uniqueSubsequence {
	boolean alphabets[] = new boolean[26];
	public void subsequenceFinder(String word, String answer, int index) {
		if (index == word.length()) {
			System.out.println(answer);
			return;
		}
		
		if (!alphabets[word.charAt(index)-'a']) {
			subsequenceFinder(word,answer+word.charAt(index),index+1);
			alphabets[word.charAt(index)-'a'] = true;
		}
		else
			subsequenceFinder(word,answer,index+1);
			
	}

	public static void main(String args[]) {
		String word = "aaab";
		uniqueSubsequence subFinder = new uniqueSubsequence();
		subFinder.subsequenceFinder(word, "", 0);
	}
}
