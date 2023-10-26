package HashMap;

import java.util.HashMap;
import java.util.Map.Entry;
//import java.util.Map;

public class HashMapBasics {
	public static void main(String args[]) {
		//Map <Integer,Integer> hash1 = new HashMap<>();
		HashMap<Integer,Integer> hash1 = new HashMap<>();
		//Add into hashmap
		hash1.put(1, 10); 
		hash1.put(2, 20); 
		hash1.put(3, 30);
		hash1.put (10,50);
		//hash1.put(2,15);
		
		System.out.println(hash1);
		//System.out.println(hash1);
		
		//Remove from hashmap
		//hash1.remove(3);//only through key
		//System.out.println(hash1);
		
		// How to get keys and values
		//boolean keyExists = hash1.containsKey(2);//if a particular key exists
		//System.out.println(keyExists);
		
		//System.out.println(hash1.containsValue(50));
		
		//Iteration
		
		for (Entry<Integer, Integer> entry : hash1.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
		}
		
		/*
		 * Here keys are random so this doesn't provide the correct and desired output always
		for (int i = 1; i<= hash1.size(); i++) {
			System.out.println(i+"="+hash1.get(i));
		}
		*/
	}

}
