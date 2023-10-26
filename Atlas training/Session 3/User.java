//This is the class for Assignment 3 Question 2
import java.lang.String;

public class User 
{
	String name;
	String emailID;
	String phoneNo;
	String gender;
	int error;
	
	Address [] address;
	
	User()
	{
		name="";
		emailID = "";
		phoneNo = "";
		gender = "";
		error=0;
	}
	
	User (String name, String emailID, String phoneNo, String gender)
	{
		if (emailID.contains("@") && emailID.contains(".com") && phoneNo.length() == 10 && (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Others")))
		{
			this.name = name;
			this.emailID = emailID;
			this.phoneNo = phoneNo;
			this.gender = gender;
		}
		
		else
		{
			this.error=1;
			System.err.println("Incorrect Input, Kindly validate your Input \n emailID should contain @ and .com \n Phone number should be 10 digit \n gender should be either male or female or others");
		}
	}
	
	public void setAddress(Address[] address)
	{
		this.address=address;
	}
	
	public void userDisplay()
	{
		if (error == 0)
			{
				System.out.println("User name is "+name);
				System.out.println("User emailID is "+emailID);
				System.out.println("User phone Number is "+phoneNo);
				System.out.println("User gender is "+gender);
				
				System.out.println("User Addresses are");
				
				for (Address addr : address)
				{
					addr.showAddress();
					System.out.println();
				}
			}
	}
}