// A binary search Tree is a Tree where the Left<Root<Right
// Left and right Subtrees should also be a BST
// For searching an element in a Binary Search Tree, it takes 
// O(log n) in the worst case as just like binary search, we won't
// be traversing through the entire tree

// Let's write a code to search for an element 'n' in the binary search tree

package BST;

import Trees.Node;

public class BST_Theory {
	Node node;
	public Node searchElementinTree (Node treeNode, int searchElement) {
		
		while (treeNode != null) {
		
			if (treeNode.data != searchElement) {
				treeNode = (treeNode.data > searchElement) ? treeNode.left : treeNode.right;
			}
			else {
				return treeNode;
			}
		}
		return null;
	}
	
	public static void main(String args[]) {
		
		BST_Theory tree = new BST_Theory();
		tree.node = new Node(1);
        tree.node.left = new Node(3);
        tree.node.right = new Node(6);
        tree.node.left.left = new Node(2);
        tree.node.left.right = new Node(4);
        tree.node.right.left = new Node(5);
        tree.node.right.right = new Node(7);
        
        System.out.println(tree.searchElementinTree(tree.node, 7).data);
	}
}
