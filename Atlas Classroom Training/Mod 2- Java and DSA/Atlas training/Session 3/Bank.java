
public class Bank 
{
	String accountNo;
	String name;
	int balance;
	
	public Bank()
	{
		accountNo = "Na";
		name = "Na";
		balance=0;
	}

	public Bank(String accountNo, String name, int balance)
	{
		this.accountNo = accountNo;
		this.name=name;
		this.balance=balance;
	}
	
	public void displayDetails()
	{
		System.out.println("ACCOUNT DETAILS");
		System.out.println("________________");
		System.out.println("Account number: "+accountNo);
		System.out.println("Account holder name: "+name);
		System.out.println("Account balance: "+balance);
		System.out.println();
		System.out.println();
	}
		
}
