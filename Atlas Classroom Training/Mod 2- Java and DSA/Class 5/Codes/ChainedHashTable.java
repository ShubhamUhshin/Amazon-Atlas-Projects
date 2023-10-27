
public class ChainedHashTable {

	static String TAG = "[ChainedHashTable] ";
	
	Integer capacity;
	Integer size;
	
	LinkedList[] buckets;
	
	public ChainedHashTable() {
		this(10);
	}
	
	public ChainedHashTable(int capacity) {
		this.capacity = capacity;
		size = 0;
		// HashTable Buckets which has Nodes inside it as Slots
		buckets = new LinkedList[capacity];
		print("Created HashTable with Capacity of "+capacity+" and buckets is: "+buckets);
	}
	
	int hash(Integer key) {
		int hashCode = key % capacity;
		return hashCode;
	}
	
	void put(Integer data) {
		
		int idx = hash(data);
		
		if(buckets[idx] == null) {
			buckets[idx] = new LinkedList();
			print("LinkedList Created for "+idx+" hashCode: "+buckets[idx]);
		}
		
		size++;
		buckets[idx].add(data);
		print("Data "+data+" Added at "+idx);
		
	}
	
	void iterate() {
		
	}
	
	void remove(int data) {
		
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
