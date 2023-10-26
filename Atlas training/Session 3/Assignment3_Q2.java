
public class Assignment3_Q2 
{
	public static void main(String args[])
	{
		User user1 = new User("Shubham Srivastava","srvshu@amazon.com","8789978812","Male");
		Address addresses[] = new Address[2];
		addresses[0] = new Address("WTC","Rajaji Nagar","Near Orion Mall","Bangalore","750058");
		addresses[1] = new Address("17","Mahadevpura","Near More Megastore","Bangalore","750048");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("User"+user1);
		user1.setAddress(addresses);
		user1.userDisplay();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
