
public class HashTable {

	static String TAG = "[HashTable] ";
	
	Integer capacity;
	Integer size;
	
	// Instead of the integer buckets, we got the Objects now
	// Which means it can store any type of Object
	
	// Keys are the indexes i.e. HashCode for us and they are as of now Integer only :)
	// Values will be some User Defined Objects
	Object[] buckets;
	
	HashTable(){
		//capacity = 10;
		//buckets = new Object[capacity];
		//print("Created with default Size of 10");
		this(10); // Executing Parameterized Constructor to create HashTable with capacity of 10 bucket as default capacity
	}
	
	HashTable(int capacity){
		this.capacity = capacity;
		buckets = new Object[capacity];
		size = 0;
		print("Created HashTable with Capacity of "+capacity+" at "+buckets);
	}
	
	// Hash Function Computes the Index for the Object to be inserted in the HashTable Bucket
	int hash(Integer key) {
		int hashCode = key % capacity;
		return hashCode;
	}
	
	/*boolean put(Integer key, Object value) {
		
		int idx = hash(key);
		
		if(buckets[idx] == null) {
			buckets[idx] = value;
			size++;
			print("For Key: "+key+" Value Added at index "+idx);
			return true;
		}else {
			print("Key Value Pair Already Exists: "+key+" at index: "+idx);
			return false;
		}
	}*/
	
	// put will insert or update :)
	boolean put(Integer key, Object value) {
		
		int idx = hash(key);
		
		if(buckets[idx] == null) {	
			size++;
		}
		
		buckets[idx] = value;
		print("For Key: "+key+" Value Added at index "+idx);
		
		
		return true;
	}
	
	void iterate() {
		System.out.println(TAG+"Iterating Buckets Started");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Iterating in buckets array
		for(int idx=0;idx<buckets.length;idx++) {
			if(buckets[idx] != null) {
				
				// Downcast the Object back to Employee
				Employee emp = (Employee)buckets[idx];
				emp.showEmployee();
				System.out.println("^^^^^^^^^^^^^^^^^^");
		
			}
		}
		System.out.println(TAG+"Iterating Buckets Finished");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	
	Object get(Integer key) {
		
		int idx = hash(key);
		
		Employee emp = (Employee)buckets[idx];
		
		if(emp.employeeId == key)
			return buckets[idx]; // O(1)
		else
			return null;
	}
	
	boolean remove(Integer key) {
		
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
