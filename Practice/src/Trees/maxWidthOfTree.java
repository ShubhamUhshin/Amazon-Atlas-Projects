package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class maxWidthOfTree {
	
	Node treeNode;
	
	public int maxWidth(Node treeNode) {
		
		if (treeNode == null)
			return 0;
		
		int answer = 0;
		Queue <Pair> q = new LinkedList<>();
		
		q.offer(new Pair(treeNode,0));
		
		while (!q.isEmpty()) {
			
			int size = q.size();
			int mmin = q.peek().value;
			int first = 0,last = 0;
			
			for (int i = 0; i < size; i++) {
				
				int curId = q.peek().value - mmin;
				Node node = q.peek().key;
				q.poll();
				if (i == 0)
					first = curId;
				
				if (i == size-1)
					last = curId;
				
				if (node.left != null)
					q.offer(new Pair(node.left,curId*2+1));
				
				if (node.right != null)
					q.offer(new Pair(node.right,curId*2+2));
				
			}
			
			answer = Math.max(answer,last - first + 1);
		}
		
		return answer;
	}

	public static void main(String args[]) {
		
		maxWidthOfTree tree = new maxWidthOfTree();
		
		tree.treeNode = new Node (1);
		tree.treeNode.left = new Node(2);
		tree.treeNode.right = new Node(3);
		tree.treeNode.left.left = new Node(4);
		tree.treeNode.left.right = new Node(5);
		tree.treeNode.right.left = new Node(6);
		tree.treeNode.right.right = new Node(7);
		
		int answer = tree.maxWidth(tree.treeNode);
		
		System.out.println(answer);
		
	}
}
