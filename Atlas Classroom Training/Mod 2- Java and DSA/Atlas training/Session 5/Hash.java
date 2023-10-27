
public class Hash 
{
	int capacity;
	int idx;
	int[] hashTable;
	
	public Hash()
	{
		capacity = 10;
		hashTable = new int[capacity];
	}
	
	public void hashing(int value)
	{
		idx = value % capacity;
		
		if (hashTable[idx] == 0)
			hashTable[idx] = value;
		
		else
		{
			if (idx < ( capacity - 1 ))
			{
				if (hashTable[idx+1] == 0)
					hashTable[idx+1] = value;
			}
			else
				System.out.println("ERROR: " +value+" cannot be stored");
		}
		
	}
	
	public void display()
	{
		for (int i : hashTable)
		{
			System.out.println(i);
		}
	}
	
}
