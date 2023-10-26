package Queues;

import LinkedList.Node;

public class QueueLL {
	
	Node head = null;
	Node tail = null;
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void insert(int element) {
		
		Node newNode = new Node(element);
		
		if (isEmpty()) 
			tail = head = newNode;//For first node
		
		else {
			tail.nextNode = newNode;
			tail = newNode;
		}
	}
	
	public int delete() {
		if (isEmpty()) {
			System.out.println("Is Empty");
			return -1;
		}
		
		int front = head.node;
		
		if (head == tail) //if Queue has only 1 element
			tail = null;
		
		head = head.nextNode;
		return front;
		
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Is Empty");
			return -1;
		}
		
		return head.node;
	}
	
	public static void main(String args[]) {
		QueueLL QueueAL = new QueueLL();
		QueueAL.insert(10);
		QueueAL.insert(20);
		QueueAL.insert(30);
		
		while (!QueueAL.isEmpty()) {
			System.out.println("Element Deleted "+QueueAL.peek());
			QueueAL.delete();
		}	
	}
}
