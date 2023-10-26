package Trees;

public class Diameter {
	
	Node node;
	public int longestDiameter(Node node) {
		
		int[] diameter = new int [1];
		height(node, diameter);
		return diameter[0];
	}
	
	public int height(Node node,int[] diameter) {
		
		if (node == null)
			return 0;
		int lh = height(node.left, diameter);
		int rh = height(node.right, diameter);
		
		diameter[0] = Math.max(diameter[0],lh+rh);
		
		return 1 + Math.max(lh,rh);
	}
	
	public static void main(String args[]) {
		
		Diameter tree = new Diameter();
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
	    
	    System.out.println(tree.longestDiameter(tree.node));
		
	}
}
