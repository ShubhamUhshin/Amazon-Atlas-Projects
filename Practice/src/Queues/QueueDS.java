package Queues;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;

public class QueueDS {
	public static void main(String args[]) {
		Queue<Integer> QueueAL = new LinkedList<>();
		Queue<Integer> QueueAL1 = new ArrayDeque<>();
		
		QueueAL.add(10);
		QueueAL.add(20);
		QueueAL.add(30);
		
		while (!QueueAL.isEmpty()) {
			System.out.println(QueueAL.peek());
			QueueAL.remove();
		}	
		
		QueueAL1.add(40);
		QueueAL1.add(50);
		QueueAL1.add(60);
		
		while (!QueueAL1.isEmpty()) {
			System.out.println(QueueAL1.peek());
			QueueAL1.remove();
		}
	}
}
