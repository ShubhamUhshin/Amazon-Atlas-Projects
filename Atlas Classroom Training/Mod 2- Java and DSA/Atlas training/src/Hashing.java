import java.util.*;
public class Hashing
{
	// int capacity = 13; 
	int capacity;
	
	//creating array reference variable
	int[] buckets;
	
	
	//HashTable construction with default capacity
	public Hashing()
	{
		capacity = 10;
		buckets = new int[10];
		System.out.println("HashTable with capacity 10");
	}
	public Hashing(int capacity)
	{
		this.capacity = capacity;
		buckets = new int[capacity];
		System.out.println("Hashtable created with capacity"+capacity);
	}
	
	int hash (int value)
	{
		int hashCode = value % capacity;
		return hashCode;
	}	
	boolean put(int value)
	{
		//Insert data at index which is basically the Hashode
		int index = hash(value);
		buckets[index] = value;
		
		
		return true;
	}
	void iterate()
	{
		System.out.println("Iterating bucket started");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for (int index=0;index<buckets.length;index++)
		{
			System.out.println("[Hashtable] at index"+index+"value is"bucket[index]);
		}
	}
}