package String;

import java.util.ArrayList;

public class KDuplicates {
	
	public void convertToArray(String input, ArrayList<Character> tempArray) {
		
		for (int i = 0; i < input.length(); i++)
			tempArray.add(input.charAt(i));
	}
	
	public void removeKDuplicate(String input, int k) {
		
		ArrayList <Character> tempArray = new ArrayList<>();
		convertToArray(input,tempArray);
		int start = 1;
		int count = 0;
		
		while (start < tempArray.size()) {
			if (tempArray.get(start) == tempArray.get(start-1))
				count++;
			
			if (count == k-1) {
				int i;
				for (i = start; i > start-k; i--) {
					tempArray.remove(i);
				}
				start = start - i - 1;
				start--;
				if (start < 1)
					start = 0;
			count = 0;
			}
			
			start++;
		}
		
		input = "";
		start = 0;
		while (!tempArray.isEmpty())
			input += tempArray.get(start++);
		
		System.out.println(input);
		
	}
	
	public static void main(String args[]) {
		KDuplicates dupChecker = new KDuplicates();
		String input = "baccbbbcaa";
		int k = 3;
		dupChecker.removeKDuplicate(input,k);
	}
}