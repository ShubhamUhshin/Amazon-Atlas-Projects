package Queues;

public class queue {
	int rear;
	int front;
	
	public queue() {
		front =-1;
		rear =-1;
	}
	
	public void insert(int[] queueArray, int element) {
		
		//We insert from the rear end
		
		if (front == -1 && rear == -1)
			front = 0;
		
		if (rear == queueArray.length-1)
			System.out.println("Queue full");
		
		else {
			rear++; //4
			queueArray[rear] = element;
		}
	}
	
	public void delete() {
		// We delete from front end
		if (front > rear)
			System.out.println("Queue Empty");
		
		else 
			front++;
	}

	public void display(int[] queueArray) { //peek
		
		if (front > rear) // 1 element needs to be modified
			System.out.println("Queue is empty");
		
		else {
			for (int i=front;i<=rear;i++) {
				System.out.print(queueArray[i]+" ");
			}
		}	
	}
	
	public static void main(String[] args) {
		int[] queueArray = new int[5];
		
		queue Queue = new queue();
		
		Queue.insert(queueArray,5);
		System.out.println();
		Queue.display(queueArray);
		Queue.insert(queueArray,10);
		System.out.println();
		Queue.display(queueArray);
		Queue.insert(queueArray,15);
		Queue.delete();
		System.out.println();
		Queue.display(queueArray);
		Queue.delete();
		System.out.println();
		Queue.display(queueArray);
		Queue.delete();
		System.out.println();
		Queue.display(queueArray);
		Queue.insert(queueArray,5);
		Queue.insert(queueArray,5);
		System.out.println();
		Queue.display(queueArray);
		System.out.println();
		Queue.insert(queueArray,5);
		
	}
	
	
	
	
	
	
	
	
	
	
}
