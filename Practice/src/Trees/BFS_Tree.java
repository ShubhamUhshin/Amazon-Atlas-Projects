package Trees;

public class BFS_Tree {
	
	Node node;
	
	public void levelOrderTraversal(Node node) {
		
		int height = treeHeight(node);
		for (int i = 1; i<=height; i++) {
			currLevelTraversal(node,i);
		}
		
	}
	
	public void currLevelTraversal(Node node, int level) {
		
		if (node == null)
			return;
		
		else if (level == 1)
			System.out.print(node.data+" ");
		
		else {
			currLevelTraversal(node.left, level-1);
			currLevelTraversal(node.right, level-1);
		}
	}
	
	public int treeHeight(Node node) {
		
		if (node == null)
			return 0;
		
		else {
			int leftheight = treeHeight(node.left);
			int rightheight = treeHeight(node.right);
			
			if (leftheight > rightheight)
				return leftheight + 1;
			
			else
				return rightheight + 1;
		}
	}

	public static void main(String args[]) {
		
		BFS_Tree tree = new BFS_Tree();
		/*
		tree.node = new Node(1);
        tree.node.left = new Node(2);
        tree.node.right = new Node(3);
        tree.node.left.left = new Node(4);
        tree.node.left.right = new Node(5);
        */
		
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
        
        System.out.println("Level Order Traversal is: ");
        tree.levelOrderTraversal(tree.node);
	}
}
