
public class Profile 
{
	
	String username;
	String password;
	String emailID;
	static int count;
	
	public Profile()
	{
		username="";
		password="";
		emailID="";
		count=0;
	}
	
	public Profile(String username, String emailID, String password)
	{
		this.username = username;
		this.emailID = emailID;
		this.password = password;
		
	}

	public void emailIDCheck(String emailID)
	{
		if (!(emailID.contains("@") && emailID.contains(".com")))
		{
			System.err.println("ERROR!!!! Invalid Email ID");
			System.exit(0);
		}
		
		count+=1;
	}
	
	public void profileUpdate()
	{
		username+= count;
	}
	
	public void profileDisplay()
	{
		emailIDCheck(emailID);
		profileUpdate();
		System.out.println("USERNAME : "+username);
		System.out.println("emailID : "+emailID);
		System.out.println("Password: Just Kidding"+count);
		System.out.println();
	}	
}
