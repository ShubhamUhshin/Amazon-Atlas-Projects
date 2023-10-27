
class Cab{
	
	int baseFare;
	int pricePerKm;
	
	Cab(){
		baseFare = 50;
		pricePerKm = 7;
		System.out.println("[Cab] Object Constructed - Default Constructor");
	}
	
	void bookCab(String source, String destinition, int distance) {
		System.out.println("````````````````````````````````````````");
		System.out.println("[Cab] Booked from "+source+" to "+destinition);
		int fare = baseFare + pricePerKm*distance;
		System.out.println("[Cab] Please Pay \u20b9"+fare);
		System.out.println("````````````````````````````````````````");
		System.out.println();
	}
}


// OLAMiniCab IS-A Cab
class OLAMiniCab extends Cab{
	
	boolean isWaterAvailable;
	boolean isSanitizerAvailable;
	
	OLAMiniCab(){
		isWaterAvailable = true;
		isSanitizerAvailable = true;
		pricePerKm += 1;
		System.out.println("[OLAMiniCab] Object Constructed - Default Constructor");

	}
	
	// ReDefine the same Method, with same signature in the Child
	// Method Overriding
	void bookCab(String source, String destinition, int distance) {
		System.out.println("````````````````````````````````````````");
		System.out.println("[OLAMiniCab] Booked from "+source+" to "+destinition);
		System.out.println("[OLAMiniCab] Water Availability: "+isWaterAvailable);
		System.out.println("[OLAMiniCab] Sanitizer Availability: "+isSanitizerAvailable);
		int fare = baseFare + pricePerKm*distance;
		System.out.println("[OLAMiniCab] Please Pay \u20b9"+fare);
		System.out.println("````````````````````````````````````````");
		System.out.println();
	}
}

public class RunTimePolymorphismApp {

	public static void main(String[] args) {
	
		/*Cab cab; 			// Reference variable of Cab
		cab = new Cab(); 	// Create the Object of Cab
		cab.bookCab("Home", "Work", 5);
		
		OLAMiniCab miniCab;
		miniCab = new OLAMiniCab();
		miniCab.bookCab("Home", "Work", 5);*/
		
		Cab cab;
		
		cab = new Cab();
		System.out.println("cab is: "+cab);
		cab.bookCab("Home", "Work", 5);
		
		// RULE: Parent's Reference Variable can refer to the Child Object, but vice-versa its an error
		// Reference Variable cab of the Parent Cab is referring to the Child Object i.e. OLAMiniCab
		// Polymorphic Statement
		cab = new OLAMiniCab();
		System.out.println("cab now is: "+cab);
		cab.bookCab("Home", "Work", 5);
		

	}

}
