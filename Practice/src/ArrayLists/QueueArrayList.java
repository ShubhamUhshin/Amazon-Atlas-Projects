package ArrayLists;
import java.util.ArrayList;
public class QueueArrayList {
	
	ArrayList<Integer> queue = new ArrayList<>();
	int rear=-1, front=-1;
	
	public boolean isEmpty() {
		if (rear == -1 && front == 0)
			return true;
		else
			return false;
			
	}
	
	public void insert(int element) {
		if (front == -1)
			front = 0;
		
		rear++;
		queue.add(rear,element);
		
	}
	
	public int delete() {
		if (isEmpty()) {
			front = -1;
			rear = -1;
			System.out.println("Queue empty");
			return -1;
		}
		else {
			int element = queue.get(front);
			queue.remove(front);
			rear--;
			return element;
		}
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue empty");
			return -1;
		}
		else 
			return queue.get(front);
	}
		
	
	public static void main(String args[]) {
		QueueArrayList QueueAL = new QueueArrayList();
		
		QueueAL.insert(10);
		QueueAL.insert(20);
		QueueAL.insert(30);
		while (!QueueAL.isEmpty()) {
			System.out.println(QueueAL.peek());
			QueueAL.delete();
		}
		
		
	}

}
