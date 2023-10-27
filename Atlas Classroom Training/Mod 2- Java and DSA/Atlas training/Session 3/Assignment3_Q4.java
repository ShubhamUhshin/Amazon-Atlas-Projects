
public class Assignment3_Q4
{
	public static void main(String[] args)
	{
		Bank account1 = new Bank("212173314","Sameer",200);
		account1.displayDetails();
		
		Bank account2 = new Bank();
		account2.accountNo="212176914";
		account2.name="Banchor Das Chatrivala";
		account2.balance=20;
		account2.displayDetails();
	}
}
