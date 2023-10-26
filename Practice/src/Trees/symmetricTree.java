package Trees;

public class symmetricTree {

	Node tree1, tree2;
	public boolean isSymmetricTree(Node tree1, Node tree2) {
		if (tree1 == null || tree2 == null)
			return tree1 == tree2;
		
		if (tree1.data != tree2.data)
			return false;
		
		return isSymmetricTree(tree1.left, tree2.right) && isSymmetricTree(tree1.right, tree2.left);
	}
	
	public static void main(String args[]) {
		symmetricTree tree = new symmetricTree();
		
		tree.tree1 = new Node (1);
		tree.tree1.left = new Node(2);
		tree.tree1.right = new Node(3);
		tree.tree1.left.left = new Node(4);
		tree.tree1.left.right = new Node(5);
		tree.tree1.right.left = new Node(6);
		tree.tree1.right.right = new Node(7);
		
		tree.tree2 = new Node (1);
		tree.tree2.right = new Node(2);
		tree.tree2.left = new Node(3);
		tree.tree2.right.right = new Node(4);
		tree.tree2.right.left = new Node(5);
		tree.tree2.left.right = new Node(6);
		tree.tree2.left.left = new Node(7);
		
		System.out.println(tree.isSymmetricTree(tree.tree1,tree.tree2));
	}
}
