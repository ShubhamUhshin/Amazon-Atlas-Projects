package Stacks;

public class stack {
	int top;
	
	public stack() {
		top =-1;
	}
	
	public void push(int[] stackArray, int element) {
		
		if (top == stackArray.length-1) // 0 == 4
			System.out.println("Stack full");
		
		else {
			top++; // 1
			System.out.println("Inserted element: "+element);
			stackArray[top] = element;
		}
	}
	
	public void pop(int[] stackArray) {
		
		if (top == -1)
			System.out.println("Stack empty");
		
		else {
			System.out.println("Popped element =" +stackArray[top]); //4
			top--; 
		}
		
	}
	
	public void peek(int[] stackArray) {
		System.out.println(stackArray[top]);
	}
	
	public void display(int[] stackArray) {
		for (int i=0;i<=top;i++) {
			System.out.print(stackArray[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		int[] stackArray = new int [5];
		
		stack Stack = new stack();
		Stack.push(stackArray,3);
		Stack.display(stackArray);
		Stack.push(stackArray,4);
		Stack.display(stackArray);
		Stack.pop(stackArray);
		Stack.peek(stackArray);
		Stack.display(stackArray);
		Stack.push(stackArray,7);
		Stack.display(stackArray);
		Stack.push(stackArray,10);
		Stack.display(stackArray);
		Stack.push(stackArray,8);
		Stack.display(stackArray);
		Stack.pop(stackArray);
		Stack.display(stackArray);
		Stack.push(stackArray,8);
		Stack.push(stackArray,8);
		Stack.push(stackArray,8);
		Stack.push(stackArray,8);
		Stack.display(stackArray);
		Stack.pop(stackArray);
		Stack.pop(stackArray);
		Stack.pop(stackArray);
		Stack.pop(stackArray);
		Stack.pop(stackArray);
		Stack.pop(stackArray);
	}

}
