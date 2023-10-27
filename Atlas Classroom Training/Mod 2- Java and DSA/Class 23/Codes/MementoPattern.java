package com.amazon.atlas22.queries;

class Message{
	
	String text;
	
	Message(){
		text = "NA";
	}
	
	void setMessage(String text){
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}

}

public class MementoPattern {

	public static void main(String[] args) {
	
		Message message = new Message();
		System.out.println("Message Initially is: "+message);
		
		message.setMessage("Hello, How Are You");
		System.out.println("Message is: "+message);
		
		message.setMessage("Lets catch up");
		System.out.println("Message is: "+message);
		
		// Undo
		System.out.println("Message is: "+message);
		
		
	}

}
