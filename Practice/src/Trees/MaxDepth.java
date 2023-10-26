// Finding Maximum depth of a binary tree

package Trees;

public class MaxDepth {
	
	Node node;
	
	public int maxDepthOfTree(Node node) {
		
		if (node == null)
			return 0;
		int lh = maxDepthOfTree(node.left);
		int rh = maxDepthOfTree(node.right);
		return 1 + Math.max(lh,rh);
	}

	public static void main(String args[]) {
		
		MaxDepth tree = new MaxDepth();
		tree.node = new Node(1);
	    tree.node.left = new Node(2);
	    tree.node.right = new Node(6);
	    tree.node.left.left = new Node(3);
	    tree.node.left.right = new Node(4);
	    tree.node.right.left = new Node(7);
	    tree.node.right.right = new Node(8);
	    tree.node.left.right.left = new Node(5);
	    tree.node.right.left.right = new Node(9);
	    tree.node.right.right.left = new Node(10);
	    tree.node.right.right.right = new Node(11);
	    
	    int height = tree.maxDepthOfTree(tree.node);
	    
	    System.out.println(height);
	}
	
}
