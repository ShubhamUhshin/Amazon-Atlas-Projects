/*
 * To check if the tree is balanced or not.
 * A tree is said to be balanced if the height of the left subchild is same as the height
 * of the right subchild.
 */

package Trees;

public class BalancedTree {
	
	Node node;
	
	public boolean isBalanced(Node node) {
		return balanceHeight(node) != -1;
	}
	
	public int balanceHeight(Node node) {
		
		if (node == null)
			return 0;
		
		int lh = balanceHeight(node.left);
		if (lh == -1)
			return -1;
		
		int rh = balanceHeight(node.right);
		if (rh == -1)
			return -1;
		 
		if (Math.abs(lh-rh)>1)
			return -1;
		
		return Math.max(lh,rh)+1;
	}
	
	public static void main(String args[]) {
		
		BalancedTree tree = new BalancedTree();
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
	    
	    if(tree.isBalanced(tree.node))
	    	System.out.println("Tree is balanced");
	    
	    else {
			System.out.println("Not balanced");
		}
	}
}
