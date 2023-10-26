import java.util.*;

public class HashTable 
{
	public static void main(String args[])
	{
		Hashing table1 = new Hashing();//capacity = 10
		Hashing table2 = new Hashing(13);//capacity =13
	
		table2.put(15);
		table2.put(20);
		
		table2.iterate();
	}
}
