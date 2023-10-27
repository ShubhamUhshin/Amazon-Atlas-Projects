
public class HashTableLP {

	Integer capacity;
	Integer size;
	
	Integer[] buckets;
	
	static String TAG = "[HashTableLP] ";
	
	HashTableLP(){
		this(10);
	}
	
	HashTableLP(int capacity){
		this.capacity = capacity;
		buckets = new Integer[capacity];
		size = 0;
		print("Created HashTable with Capacity of "+capacity+" at "+buckets);
	}
	
	int hash(Integer key) {
		int hashCode = key % capacity;
		return hashCode;
	}
	
	// put will insert or update :)
	boolean put(Integer data) {
		
		int idx = hash(data);
		
		if(buckets[idx] == null) {	
			size++;
		}
		
		buckets[idx] = data;
		print("Data: "+data+" Added at HashCode i.e. idx: "+idx);
		
		return true;
	}
	
	void iterate() {
		System.out.println(TAG+"Iterating Buckets Started SIZE: "+size+" Capacity: "+capacity);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Iterating in buckets array
		for(int idx=0;idx<buckets.length;idx++) {
			if(buckets[idx] != null) {
				System.out.println("Key: "+idx+" Value: "+buckets[idx]);
				System.out.println("^^^^^^^^^^^^^^^^^^");
			}
		}
		System.out.println(TAG+"Iterating Buckets Finished");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	static void print(String text) {
		System.out.println(TAG+text);
	}
	
	int size() {
		return size;
	}
	
	int capacity() {
		return capacity;
	}
	
}
