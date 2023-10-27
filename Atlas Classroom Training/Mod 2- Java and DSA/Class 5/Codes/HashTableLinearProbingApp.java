
public class HashTableLinearProbingApp {

	public static void main(String[] args) {
		
		HashTableLP table = new HashTableLP(29);
		System.out.println("[main] Size: "+table.size()+" Capacity: "+table.capacity());

		table.put(10);
		table.put(20);
		table.put(29);
		table.put(58);
		
		table.iterate();
		
	}


}
