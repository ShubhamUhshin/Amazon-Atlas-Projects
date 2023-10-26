package recursion;

public class TowerOfHanoi {
	
	public static void moveDisk(int n, String Source, String Helper, String Destination) {
		if (n == 1) {
			System.out.println("Move disk "+n+" From "+Source+" To "+Destination);
			return;
		}
		//n-1 disk Source -> helper using dest
		moveDisk(n-1,Source,Destination,Helper);
		
		//nth disk -> source to destination
		System.out.println("Move disk "+n+" From "+Source+" To "+Destination);
		
		// move from helper  to destination using source
		moveDisk(n-1,Helper,Source,Destination);
	}
	
	public static void main(String args[]) {
		
		moveDisk(3,"SOURCE","HELPER","DESTINATION");
		
	}

}
