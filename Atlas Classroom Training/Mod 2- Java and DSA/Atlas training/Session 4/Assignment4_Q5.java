public class Assignment4_Q5 
{
	public static void main(String args[])
	{
	Chat list = new Chat();
	list.addMessage(new Message("1. Hello!!","12:10",true));
	list.addMessage(new Message("2. This is Awesome to know you are learning Java", "12:50", true));
	list.addMessage(new Message("3. Data Structures are Awesome", "13:10", false));
	list.addMessage(new Message("4. Lets have a small break by 4 PM", "14:10", true));
	list.addMessage(new Message("5. Thank you :)", "13:30", false));

	System.out.println("[WhatsApp] [main] list size is: "+list.size);
	System.out.println("---------------------------------------------");
	
	list.forwardIterate(); 
	System.out.println("---------------------------------------------");
	list.backwardIterate(); 
	System.out.println("---------------------------------------------");
	list.deleteMessagefromBeginning();
	System.out.println("---------------------------------------------");
	list.deleteMessagefromEnd();
	System.out.println("---------------------------------------------");
	}
}

