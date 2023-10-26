package Stacks;
import java.util.Stack;
class StackDS{
	public static void main(String args[]) {
		Stack <Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		while (!stack.isEmpty()) {
			System.out.println(stack.peek());
			stack.pop();
		}
		
	}
}