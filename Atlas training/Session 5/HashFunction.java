import java.util.Hashtable;
public class HashFunction 
{
	
	String userInput;
	int key;
	Hashtable<Integer,String> hashTable = new Hashtable<>();
	
	public HashFunction()
	{
		userInput = "";
	}

	public HashFunction(String userInput)
	{
		this.userInput = userInput;
	}
	
	public void hashing(String userInput)
	{
		int i;
		char ch;
		int sum=0;
		int totalSum = 0;
		
		for (i=0;i<userInput.length();i++)
		{
			sum = 0;
			ch = userInput.charAt(i);
			sum = sum + (int)ch;
			sum = sum * 10 * (i+1);
			System.out.println(sum);
			totalSum += sum;
			
		}
		
		System.out.println(totalSum);
		key =(totalSum % 2069)/10;
		System.out.println("GENERATED KEY:" +key);
		hashTable.put(key,userInput);
		
	}
	
	public void display()
	{
		System.out.println(hashTable);
	}
}
