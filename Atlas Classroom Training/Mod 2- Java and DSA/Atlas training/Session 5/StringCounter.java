import java.util.HashMap;
import java.util.Map;

public class StringCounter 
{
	HashMap<Character, Integer> alphabet = new HashMap<>();
	
	public void initialize ()
	{
		int k=0;
		for (char i='A';i<='Z';i++)
		{
			alphabet.put(i,k);
		}
		
		for (char i='a';i<='z';i++)
		{
			alphabet.put(i,k);
		}
	}
	
	public void count(String string)
	{
		initialize();
		//string = string.toUpperCase();
		for (int i=0;i<string.length();i++)
		{
			if (alphabet.containsKey(string.charAt(i)))
			{
				alphabet.put(string.charAt(i), alphabet.get(string.charAt(i))+1);
			}
		}
		System.out.println("Given String: "+string);
		System.out.println(alphabet);
	}
}
