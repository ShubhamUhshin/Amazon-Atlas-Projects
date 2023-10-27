
public class Chat 
{
	Message firstMessage;
	Message lastMessage;
	int size;
	
	public void addMessage(Message message)
	{
		size++;
		
		if (firstMessage == null)
		{
			firstMessage = message;
			lastMessage = message;
		}
		
		else
		{
			message.previousMessage = lastMessage;
			lastMessage.nextMessage = message;
			lastMessage = message;
		}
	}

	void forwardIterate()
	{
		Message temp = firstMessage;
		while (temp.nextMessage != null)
		{
			temp.showMessage();
			temp=temp.nextMessage;
		}
		temp.showMessage();
	}
	
	void backwardIterate()
	{
		Message temp = lastMessage;
		while (temp.previousMessage != null)
		{
			temp.showMessage();
			temp=temp.previousMessage;
		}
		temp.showMessage();
	}
	
	void deleteMessagefromBeginning()
	{
		System.out.println("Message to be deleted: "+firstMessage.message);
		firstMessage = firstMessage.nextMessage;
		firstMessage.previousMessage = null;
		System.out.println("Deleted");
		System.out.println("---------------------------------------------");
		forwardIterate();
	}
	
	void deleteMessagefromEnd()
	{
		System.out.println("Message to be deleted: "+lastMessage.message);
		lastMessage = lastMessage.previousMessage;
		lastMessage.nextMessage = null;
		System.out.println("Deleted");
		System.out.println("---------------------------------------------");
		forwardIterate();
	}
}
