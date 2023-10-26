package LinkedList;

public class SingleLinkedList{
	Node head;
	
	public SingleLinkedList () {
		head = null;
	}
	
	public void addNodeAtBeginning(int data){
		//Adding this node in the beginning
		Node Node1 = new Node(data);
		
		if (head == null){//null check
			head = Node1;
			System.out.println("Node added at the beginning: "+head.node);
		}
		
		else {
			Node1.nextNode = head;
			head = Node1;
			System.out.println("Node added at the beginning: "+head.node);
		}
	}
	
	
	
	public void addNodeAtEnd(int data) {
		
		Node Node1 = new Node(data);//Node to be added
		
		//traverse to the end 
		
		Node start = head;
		
		while (start.nextNode != null) {
			start = start.nextNode;
		}
		
		start.nextNode = Node1;
		System.out.println("Node added to the end: "+Node1.node);
	}


	public void addNodeInMiddle(int data, int position) {
		
		Node Node1 = new Node(data);
		
		Node start = head;
		int nodeIndex = 1;
		while (start.nextNode!= null && nodeIndex < position) {
			start = start.nextNode;
			nodeIndex++;
		}
		
		Node1.nextNode = start.nextNode;
		start.nextNode = Node1;
		System.out.println("Node added at position "+position);
		
	}

	public void removeFromLast() {
		Node start = head;
		
		while (start.nextNode.nextNode != null) {
			start = start.nextNode;
		}
		
		start.nextNode = null;
		System.out.println("Last node is deleted");
	}


	public void removeFromFirst() {
		head = head.nextNode;
		System.out.println("First node is removed");
	}
	
	public void removeFromMiddle(int position) {
		Node start = head;
		int nodeIndex = 1;
		while (start.nextNode != null && nodeIndex < position) {
			start = start.nextNode;
			nodeIndex++;
		}
		
		start.nextNode = start.nextNode.nextNode;
		start.nextNode.nextNode = null;
		System.out.println("node deleted at postion "+position);
	}

	public void traverse() {
		//display
		Node Start = head;
		while (Start != null) {
			System.out.print(Start.node+" ");
			Start = Start.nextNode;
		}		
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		SingleLinkedList list = new SingleLinkedList();
		list.addNodeAtBeginning(5);
		list.traverse();
		list.addNodeAtEnd(10);
		list.traverse();
		list.addNodeAtEnd(20);
		list.addNodeAtEnd(30);
		list.traverse();
		//list.addNodeInMiddle(15,2);
		//list.traverse();
		//list.removeFromLast();
		//list.traverse();
		//list.removeFromFirst();
		//list.traverse();
		list.removeFromMiddle(2);
		list.traverse();
	}
}
