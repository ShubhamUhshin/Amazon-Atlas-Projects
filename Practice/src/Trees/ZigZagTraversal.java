package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
	Node node;
	
	public List<Integer> zigzag(Node node){
		
		List<Integer> answer = new ArrayList<>();
		Node treeNode;
		boolean leftToRight = false;
		Queue <Node> treeElements = new ArrayDeque<>();
		treeElements.add(node);
		while (!treeElements.isEmpty()) {
			int size = treeElements.size();
			int [] elements = new int [size];
			
			for (int i = 0;i<size;i++) {
				
				treeNode = treeElements.peek();
				treeElements.remove();
				
				int index = (leftToRight) ? i : size - 1 -i;
				
				elements[index] = treeNode.data;
				
				if (treeNode.left != null)
					treeElements.add(treeNode.left);
				
				if (treeNode.right != null)
					treeElements.add(treeNode.right);
			}
			
			leftToRight = !(leftToRight);
			for (int i : elements)
				answer.add(i);
		}
		
		return answer;
	}
	
	public static void main(String args[]) {
		
		ZigZagTraversal tree = new ZigZagTraversal();
		tree.node = new Node(1);
	    tree.node.left = new Node(2);
	    tree.node.right = new Node(6);
	    tree.node.left.left = new Node(3);
	    tree.node.left.right = new Node(4);
	    tree.node.right.left = new Node(7);
	    tree.node.right.right = new Node(8);
	    tree.node.left.right.left = new Node(5);
	    // tree.node.right.left.right = new Node(9);
	    tree.node.right.right.left = new Node(10);
	    tree.node.right.right.right = new Node(11);
	    
	    List<Integer> answer = tree.zigzag(tree.node);
	    for (Integer element : answer)
	    	System.out.print(element+" ");
	}
}
