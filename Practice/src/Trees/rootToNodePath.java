// WAP to input a node, and find the ath to the node from the root.
// We'll use recursion to solve this problem.
// We'll use in order traversal because pre, post will make the solution more complicated.

package Trees;

import java.util.ArrayList;


public class rootToNodePath {
	
	Node treeNode;
	boolean found = false;
	public ArrayList <Integer> answer = new ArrayList<>();
	
	public ArrayList<Integer> pathFinder (Node treeNode, int value){
		
		if (treeNode == null) {
			return answer;
		}
		
		if (treeNode.data == value) {
			found = true;
			answer.add(value);
			return answer;
		}
		
		answer.add(treeNode.data);
		pathFinder(treeNode.left, value);
		if (!found)
			answer.remove(answer.size()-1);
		
		else {
			return answer;
		}
		answer.add(treeNode.data);
		pathFinder(treeNode.right, value);
		if (!found)
			answer.remove(answer.size()-1);
		
		else {
			return answer;
		}
		return answer;
	}
	
	// Striver solution
	public boolean getPath(Node treeNode, int value, ArrayList<Integer> answer) {
		
		if (treeNode == null)
			return false;
		
		answer.add(treeNode.data);
		if (treeNode.data == value)
			return true;
		
		if (getPath(treeNode.left,value,answer) || getPath(treeNode.right,value,answer))
			return true;
		
		answer.remove(answer.size()-1);
		return false;
	}
	
	
	public static void main(String args[]) {
		
		rootToNodePath tree = new rootToNodePath();
		
		tree.treeNode = new Node(1);
		tree.treeNode.left = new Node (2);
		tree.treeNode.right = new Node (3);
		tree.treeNode.left.left = new Node (4);
		tree.treeNode.left.right = new Node (5);
		tree.treeNode.left.right.left = new Node (6);
		tree.treeNode.left.right.right = new Node (7);
		tree.treeNode.left.right.right.left = new Node (8);
		
		tree.pathFinder(tree.treeNode, 7);
		
		for (Integer i : tree.answer) {
			System.out.print(i+" ");
		}
		
		tree.answer.clear();
		System.out.println();
		tree.getPath(tree.treeNode, 7, tree.answer);
		
		for (Integer i : tree.answer) {
			System.out.print(i+" ");
		}
	}

}
