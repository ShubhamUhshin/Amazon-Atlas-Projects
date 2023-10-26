package recursion;

import LinkedList.Node;

public class RecursionLLDeletion {
	Node head;
	
	public void push(int data) {
		Node newNode = new Node(data);
		
		if (head == null) {
				head = newNode;
				System.out.println("Node Inserted is "+newNode.node);
		}		
		else {
			Node start;
			start = head;
			
			while (start.nextNode != null) {
				start = start.nextNode;
			}
			
			start.nextNode = newNode;
			System.out.println("Node Inserted is "+newNode.node);
		}
	}
	
	public void delete(Node head) {
		if (head == null) {
			System.out.println("List empty");
			return;
		}
		System.out.println("Node deleted is "+head.node);
		delete(head.nextNode);
	}
	public static void main(String[] args) {
		RecursionLLDeletion LL = new RecursionLLDeletion();
		LL.push(5);
		LL.push(10);
		LL.push(20);
		LL.delete(LL.head);
	}
}
