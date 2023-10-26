// Move all 'x' to the end

package recursion;

public class StringManupulation {
	public String manupulate(String word, String result, int index, int count) {
		if (index == word.length()) {
			for (int i=0;i<count;i++) {
				result+='x';
			}
			
			//System.out.println(result);
			return result;
		}
		
		if (word.charAt(index) != 'x')
			result += word.charAt(index);
		
		else
			count++;
		
		result = manupulate(word,result,index+1,count);
		return result;
	}
	
	public static void main(String args[]) {
		StringManupulation manupulator = new StringManupulation();
		String word = "axxbxcdxef";
		System.out.println(manupulator.manupulate(word,"",0,0));
	}

}
