// Top View Of A Binary Tree.
// One node per level.
// In the vertical traversal, we 

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
	
	Node node;
	
	public List<List<Integer>> topView(Node node){
		
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		
		List<List<Integer>> answer = new ArrayList<>();
		
		if (node == null)
			return answer;

		Queue <Tuple> q = new LinkedList<>();
		q.offer(new Tuple(node,0,0));
		
		while (!q.isEmpty()) {
			
			Tuple tuple = q.poll();
			Node node1 = tuple.node;
			
			int x = tuple.row;
			int y = tuple.column;
			
			if (!map.containsKey(x)) {
				map.put(x, new TreeMap<>());
				if (!map.get(x).containsKey(y)) {
					map.get(x).put(y, new PriorityQueue<>());
			
				if (node1.left != null)
					q.offer(new Tuple (node1.left,x-1,y+1));
			
				if (node1.right != null)
					q.offer(new Tuple(node1.right,x+1,y+1));
				
				
				map.get(x).get(y).offer(node1.data);
				}
			}
		}
		
		for (TreeMap<Integer, PriorityQueue<Integer>> value : map.values()) {
			answer.add(new ArrayList<>());
			for (PriorityQueue<Integer> nodes : value.values()) {
				if (!nodes.isEmpty()) {
					System.out.println(nodes.peek());
					answer.get(answer.size()-1).add(nodes.poll());
				}
			}
		}
		return answer;
	}
	
	
	// Optimized code as per Striver's solution
	public List<Integer> topViewOptimized(Node node){
		
		List<Integer> answer = new ArrayList<>();
		if (node == null)
			return answer;
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue <Pair> q = new LinkedList<>();
		
		q.offer(new Pair(node,0));
		
		while (!q.isEmpty()) {
			
			Pair val = q.remove();
			int level = val.value;
			Node node1 = val.key;
			
			if (map.get(level) == null)
				map.put(level,node1.data);
				
			if (node1.left != null)
				q.offer(new Pair(node1.left,level-1));
			
			if (node1.right != null)
				q.offer(new Pair(node1.right,level+1));
		}
		
		for (Map.Entry<Integer, Integer> value : map.entrySet())
			answer.add(value.getValue());
		
		return answer;
		
	}

		public static void main(String args[]) {
			
			TopView tree = new TopView();
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
		    /*
		    List<List<Integer>> answer = new ArrayList<>();
		    answer = tree.topView(tree.node);
		    
		    for (List<Integer> value : answer) {
		    	if (!value.isEmpty()) {
		    		for (Integer i : value) {
		    			System.out.print(i+" ");
		    		}
		    	}
		    }
		     */
		    List<Integer> answer = new ArrayList<>();
		    answer = tree.topViewOptimized(tree.node);
		    
		    for (Integer value : answer)
		    	System.out.print(value+" ");
		}
}
