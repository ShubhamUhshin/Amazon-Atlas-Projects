// Side View of a binary Tree
// Both Level Order Traversal and recursive solution.
// Depending on the side, we display the side most element at each level

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


public class SideView {
	
	Node node;
	
	// Iterative Solution or Level Order Traversal Solution
	// But this takes more time than recursive solution
	public List<Integer> leftToRight(Node node){
		
		List <Integer> answer = new ArrayList<>();
		
		if (node == null)
			return answer;
		
		Queue <Pair> treeElements = new LinkedList<>();
		TreeMap<Integer, Integer>map = new TreeMap<>();
		
		treeElements.offer(new Pair(node,0));
		
		while (!treeElements.isEmpty()) {
			
			Pair elements = treeElements.remove();
			Node node1 = elements.key;
			int level = elements.value;
			
			if (map.get(level) == null)
				map.put(level,node1.data);
			
			if (node1.left != null)
				treeElements.offer(new Pair(node1.left, level+1));
			
			if (node1.right != null)
				treeElements.offer(new Pair(node1.right,level+1));
		}
		
		for (Map.Entry<Integer, Integer> value : map.entrySet())
			answer.add(value.getValue());
		
		return answer;
	}
	
	// Left View using recursion
	public void leftView(Node node, List<Integer> answer, int currLevel){
		
		if (node == null)
			return;
		
		if (answer.size() == currLevel)
			answer.add(node.data);
		
		leftView(node.left,answer,currLevel+1);
		leftView(node.right,answer,currLevel+1);
	}
	
	public List<Integer> rightToLeft(Node node){
		
		List <Integer> answer = new ArrayList<>();
		
		if (node == null)
			return answer;
		
		Queue <Pair> treeElements = new LinkedList<>();
		TreeMap<Integer, Integer>map = new TreeMap<>();
		
		treeElements.offer(new Pair(node,0));
		
		while (!treeElements.isEmpty()) {
			
			Pair elements = treeElements.remove();
			Node node1 = elements.key;
			int level = elements.value;
			
			map.put(level,node1.data);
			
			if (node1.left != null)
				treeElements.offer(new Pair(node1.left, level+1));
			
			if (node1.right != null)
				treeElements.offer(new Pair(node1.right,level+1));
		}
		
		for (Map.Entry<Integer, Integer> value : map.entrySet())
			answer.add(value.getValue());
		
		return answer;
	}

	// Recursive solution for Right view
	public void rightView(Node node, List<Integer> answer, int currLevel){
		
		if (node == null)
			return;
		
		if (answer.size() == currLevel)
			answer.add(node.data);
		
		rightView(node.right,answer,currLevel+1);
		rightView(node.left,answer,currLevel+1);
	}

	public static void main(String args[]) {
		
		SideView tree = new SideView();
		tree.node = new Node(1);
	    tree.node.left = new Node(2);
	    tree.node.right = new Node(6);
	    tree.node.left.left = new Node(3);
	    tree.node.left.right = new Node(4);
	    tree.node.right.left = new Node(7);
	    tree.node.right.right = new Node(8);
	    tree.node.left.right.left = new Node(5);
	    // tree.node.left.right.left.left = new Node(12);
	    // tree.node.right.left.right = new Node(9);
	    tree.node.right.right.left = new Node(10);
	    tree.node.right.right.right = new Node(11);
	   
	    List<Integer> answer = new ArrayList<>();
	    answer = tree.leftToRight(tree.node);
	    System.out.print("Left View:\t");
	    for (Integer value : answer)
	    	System.out.print(value+" ");
	    
	    System.out.println();
	    answer.clear();
	    tree.leftView(tree.node, answer, 0);
	    System.out.print("R-Left View:\t");
	    for (Integer value : answer)
	    	System.out.print(value+" ");
	    
	    System.out.println();
	    answer.clear();
	    answer = tree.rightToLeft(tree.node);
	    
	    System.out.print("Right View:\t");
	    for (Integer value : answer)
	    	System.out.print(value+" ");
	    
	    System.out.println();
	    answer.clear();
	    tree.rightView(tree.node, answer, 0);
	    System.out.print("R-Right View:\t");
	    for (Integer value : answer)
	    	System.out.print(value+" ");
	}
}
