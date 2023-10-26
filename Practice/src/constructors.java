/*
Constructors
	-To initialize variable/data members -> when object is created
	- This is a special function
	
	3 Types
	-Parameterized
	-Non Parameterized
	-Default
	
*/

public class constructors {
	int x; //global //object 1 x=10; object 2 x = 5
	int y;
	
	public constructors() {
		x = 0;
		y = 0;
		System.out.println(x+" "+y);
	}
	
	//this.x for object 1
	public constructors(int x, int y) {
		this.x = x; //sum() -> class B sum() similarly x -> local variable
		this.y = y;
		System.out.println(x+" "+y);
		//This keyword is used to refer the current class object.
	}
	public void sum (int x, int y) {//Local variable/parameter
		System.out.println (x+y);
	}
	public static void main(String args[]) {
		
		constructors object1 = new constructors ();
		//constructors object2 = new constructors (5,15);
		//constructors object3 = new constructors ();
		
		object1.sum(object1.x,object1.y);
	}
	
	
	
}
