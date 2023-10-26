//Remove all duplicates in String

package recursion;

public class removeDuplicates {
	boolean alphabets[] = new boolean[26];
	
	public void duplicates(String word,String answer,int index) {
		
		if (index == word.length()) {
			System.out.println(answer);
			return;
		}
		
		if (!alphabets[word.charAt(index)-'a']) {
			answer = answer+word.charAt(index);
			alphabets[word.charAt(index)-'a'] = true;
		}
		
		duplicates(word,answer,index+1);
	}
	
	public static void main(String args[]) {
		
		String word = "abcdabbcdd";
		removeDuplicates duplicate = new removeDuplicates();
		duplicate.duplicates(word,"",0);
		
	}

}
