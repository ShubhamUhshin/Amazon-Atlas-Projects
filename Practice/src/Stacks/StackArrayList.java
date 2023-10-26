package Stacks;
import java.util.ArrayList;
public class StackArrayList {
	ArrayList<Integer> list = new ArrayList<>();
	int top;	
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
		
	public void push(int element) {
		list.add(element);
	}
		
		public int pop() {
			if (isEmpty()) //-> if length of stack = 0, then true
				return -1;
			
			else {
				top = list.remove(list.size()-1);
				return top;
			}
		}
		
		public int peek() {
			if (isEmpty())
				return -1;
			
			else
				return list.get(list.size()-1);
		}
		
		public static void main(String[] args) {
			StackArrayList Stack1 = new StackArrayList();
			Stack1.push(10);
			Stack1.push(20);
			Stack1.push(30);
			
			while (!Stack1.isEmpty()) {
				System.out.println(Stack1.peek());
				Stack1.pop();
				
		}
			
	}

}

