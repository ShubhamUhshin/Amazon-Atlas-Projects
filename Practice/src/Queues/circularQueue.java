package Queues;

public class circularQueue {
	int rear;
	int front;
	
	public circularQueue() {
		front =-1;
		rear =-1;
	}
	
	public void insert(int[] queueArray, int element) {
	 /*
	   case 1:
		rear = n-1, front =0;

		case 2:
		rear + 1 == front;
	 */
		
		if (front == 0 && rear == queueArray.length - 1)
			System.out.println("Insertion Function says: Queue is full");
		
		else if (rear + 1 == front)
			System.out.println("Insertion Function says: Queue is full");
		
		else {
			if (front == -1)
				front = 0;
			//if block ends
			
			rear = (rear + 1) % queueArray.length;
			// rear = size - 1 -> change rear -> 0
			//0,1,2,3,4 upto queueArray.length
			queueArray[rear] = element;
			System.out.println("Insertion Function says: Element inserted");
		}
	}
	
	public void delete (int[] queueArray) {
		
			/* 
			 case 1
				When front == rear
			Case 2
				front == -1
			 */
		
		if (front == -1)
			System.out.println("Deletion Function says: Queue is empty");
		
		else if (front == rear) {
			front = -1;
			rear = -1;
			System.out.println("Deletion Function says: Element deleted");
		}
		
		else {
			front = (front + 1) % queueArray.length;
			System.out.println("Deletion Function says: Element deleted");
		
		}
	}
	
	public void display(int[] queueArray) {
		if (front == -1)
			System.out.println("Display Function says: Queue empty");
		else {
			System.out.print("Display Function says: Queue is :");
				for (int i = front; i<=rear;i++) {
					System.out.print(queueArray[i]+" ");
				}
				System.out.println();
		}
	}

	public static void main(String args[]) {
		int[] queueArray = new int [5];
		
		circularQueue queue = new circularQueue();
		queue.insert(queueArray,5);
		queue.delete(queueArray);
		queue.display(queueArray);
		queue.insert(queueArray,10);
		queue.insert(queueArray,15);
		queue.insert(queueArray,20);
		queue.display(queueArray);
		queue.delete(queueArray);
		queue.delete(queueArray);
		queue.display(queueArray);
		queue.delete(queueArray);
		queue.delete(queueArray);
	}
}
