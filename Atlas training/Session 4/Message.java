// This is class for Assignment 4 Question 5
public class Message 
{
	String message;
	String timeStamp;
	boolean seen;
	Message nextMessage;
	Message previousMessage;
	
	public Message()
	{
		message="";
		timeStamp="";
		seen = false;
	}
	
	public Message(String message, String timeStamp, boolean seen)
	{
		this.message = message;
		this.timeStamp = timeStamp;
		this.seen = seen;
	}
	
	public void showMessage()
	{
		System.out.println("\u2709 "+ message);
		
		char check = '\u2713';
		char uncheck = '\u2715';
		char toPrint = seen ? check : uncheck;
		System.out.println(timeStamp+"\t\t"+toPrint);
	}
}
