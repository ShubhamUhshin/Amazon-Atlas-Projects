package Trees;

public class MaxHeight {
	
	Node node;
	
	public int maxHeight(Node node, int[] maxi) {
		
		if (node == null)
			return 0;
		
		int lh = maxHeight(node.left,maxi);
		int rh = maxHeight(node.right, maxi);
		
		maxi[0] = Math.max(maxi[0],lh+rh);
		
		return Math.max(lh+rh, node.data);
	}

	public static void main(String args[]) {
		
		int[] maxi = new int [1];
		MaxHeight tree = new MaxHeight();
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
	    
	    maxi[0] = tree.maxHeight(tree.node,maxi);
	    
	    System.out.println(maxi[0]);
	}
}
