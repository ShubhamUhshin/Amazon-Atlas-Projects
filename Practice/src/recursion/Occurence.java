//Find the first and last recursion of a character in string

package recursion;

public class Occurence {
	boolean firstOccurence = false;
	boolean lastOccurence = false;
	int firstOccurenceIndex;
	int lastOccurenceIndex;
	
	
	public void occurenceFinder(String word, char ch, int index) {
		if (index == word.length()) {
			if (firstOccurence) {
				System.out.println("first occured at "+firstOccurenceIndex);
				System.out.println("last occured at "+lastOccurenceIndex);
			}
			else
				System.out.println("not present");
			
			return;
		}
		
		if (word.charAt(index) == ch) {
			if (!firstOccurence) {
				firstOccurence = true;
				firstOccurenceIndex = index;
			}
				lastOccurence = true;
				lastOccurenceIndex = index;
			}
			occurenceFinder(word,ch,index+1);
		}
		
	
	public static void main(String args[]) {
		String word = "ababaccabv";
		char ch = 'a';
		
		Occurence occurence = new Occurence();
		occurence.occurenceFinder(word,ch,0);
		
	}
	

}
