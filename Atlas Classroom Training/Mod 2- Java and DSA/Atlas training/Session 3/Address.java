//This is class used for User class for Assignment 3 Question 2
public class Address 
{
	
	String addressLane1;
	String addressLane2;
	String landmark;
	String city;
	String zipcode;
	
	Address()
	{
		addressLane1="NA";
		addressLane2="NA";
		landmark="NA";
		city="NA";
		zipcode="NA";
	}
	
	Address(String addressLane1, String addressLane2, String landmark, String city, String zipcode)
	{
		this.addressLane1=addressLane1;
		this.addressLane2=addressLane2;
		this.landmark=landmark;
		this.city=city;
		this.zipcode=zipcode;
	}
	
	void showAddress()
	{
		System.out.print("\t Address:");
		System.out.println(addressLane1);
		System.out.println("\t"+addressLane2);
		System.out.println("\t"+landmark);
		System.out.print("\t"+city);
		System.out.println("-"+zipcode);
	}
}
