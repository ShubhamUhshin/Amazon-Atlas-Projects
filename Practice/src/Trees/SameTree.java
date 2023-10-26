package Trees;

public class SameTree {
	
	Node node1, node2;
	
	public boolean isSameTree(Node node1, Node node2) {
		if (node1 == null || node2 == null)
			return (node1 == node2);
		
		return (node1.data == node2.data) && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
	}

	public static void main(String args[]) {
		
		SameTree tree = new SameTree();
		tree.node1 = new Node(1);
	    tree.node1.left = new Node(2);
	    tree.node1.right = new Node(6);
	    tree.node1.left.left = new Node(3);
	    tree.node1.left.right = new Node(4);
	    tree.node1.right.left = new Node(7);
	    tree.node1.right.right = new Node(8);
	    tree.node1.left.right.left = new Node(5);
	    tree.node1.right.left.right = new Node(9);
	    tree.node1.right.right.left = new Node(10);
	    tree.node1.right.right.right = new Node(11);
	    
	    tree.node2 = new Node(1);
	    tree.node2.left = new Node(2);
	    tree.node2.right = new Node(6);
	    tree.node2.left.left = new Node(3);
	    tree.node2.left.right = new Node(4);
	    tree.node2.right.left = new Node(7);
	    tree.node2.right.right = new Node(8);
	    tree.node2.left.right.left = new Node(5);
	    // tree.node2.left.right.left = new Node(12);
	    tree.node2.right.left.right = new Node(9);
	    tree.node2.right.right.left = new Node(10);
	    tree.node2.right.right.right = new Node(11);
	    
	    
	    System.out.println(tree.isSameTree(tree.node1, tree.node2));
	}
}
