package Trees;

public class lowestCommonAncestor {
	
	Node treeNode;
	
	public Node lcaFinder (Node treeNode, int value1, int value2) {
		
		if (treeNode == null || treeNode.data == value1 || treeNode.data == value2)
			return treeNode;
		
		if (lcaFinder(treeNode.left,value1,value2)!=null && lcaFinder(treeNode.right,value1,value2) != null)
			return treeNode;
		
		return (lcaFinder(treeNode.left,value1,value2) == null) ? lcaFinder(treeNode.right,value1,value2) : lcaFinder(treeNode.left,value1,value2);
		
	}

	public static void main(String args[]) {
		
		lowestCommonAncestor tree = new lowestCommonAncestor();
		tree.treeNode = new Node(1);
		tree.treeNode.left = new Node (2);
		tree.treeNode.right = new Node (3);
		tree.treeNode.left.left = new Node (4);
		tree.treeNode.left.right = new Node (5);
		tree.treeNode.left.right.left = new Node (6);
		tree.treeNode.left.right.right = new Node (7);
		
		Node answer = tree.lcaFinder(tree.treeNode, 7, 3);
		
		System.out.println(answer.data);
		
	}
}
