package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
	
	Node node;
	public List<Integer> bottomView(Node node){
		
		ArrayList <Integer> answer = new ArrayList<>();
		
		if (node == null)
			return answer;
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue <Pair> q = new LinkedList<>();
		q.offer(new Pair(node,0));
		
		while (!q.isEmpty()) {
			
			Pair value = q.remove();
			int level = value.value;
			Node node1 = value.key;
			
			map.put(level,node1.data);
			
			if (node1.left != null)
				q.offer(new Pair (node1.left, level-1));
			
			if (node1.right != null)
				q.offer(new Pair (node1.right, level + 1));
		}
		
		for (Map.Entry<Integer, Integer> values : map.entrySet()) {
			answer.add(values.getValue());
		}
		
		return answer;
	}

	public static void main(String args[]) {
		
		BottomView tree = new BottomView();
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
	    
	    List<Integer> answer = new ArrayList<>();
	    answer = tree.bottomView(tree.node);
	    
	    for (Integer ans : answer)
	    	System.out.print(ans+" ");
	}
}
