package LinkedList;

public class StackLL {
	Node head; // head -> null
	
	public boolean isEmpty() {
		return head == null;
		}
	
	public void push(int data) {
		Node newNode = new Node(data); //newNode -> data=10 /nextNode ->null
		newNode.nextNode = head;
		head = newNode; //head works as top
	}
	
	public int pop() {
		if (isEmpty())
			return -1;
		else {
			int data = head.node; //30
			head=head.nextNode;
			return data;
		}
	}
	public int peek() {
		if (isEmpty())
			return -1;
		else
			return head.node;
	}
	
	public static void main(String[] args) {
		StackLL Stack1 = new StackLL();
		Stack1.push(10);
		Stack1.push(20);
		Stack1.push(30);
		while (!Stack1.isEmpty()) {
			System.out.println(Stack1.peek());
			Stack1.pop();
		}
	}
}
