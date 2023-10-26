/* Code to build a unique binary tree by a given set of instructions.
	To build a tree, what if we have
	a) Pre Order and Post Order
		Pre-Order - 1 2 3
		Post Order - 3 2 1
		Possible Trees - 
				1	|		1
			2		|	2
		3			|		3
		So, we can create trees using pre and post but not a unique.
	b) In-Order and Pre-Order
		In Order -  9 3 15 20 7
		Pre Order - 3 9 20 15 7
		Tree-
				3
			9		20
				15		7
*/

package Trees;

import java.util.HashMap;

public class buildTree {
	
	public Node buildBinaryTree (int[] preOrder, int[] inOrder) {
		HashMap<Integer,Integer> inTree = new HashMap<>();
		
		for (int i = 0; i < inOrder.length; i++) {
			inTree.put(inOrder[i],i);
		}
		
		
		Node treeNode = buildBinaryTree (preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,inTree);
		return treeNode;
	}
	
	public Node buildBinaryTree(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,HashMap<Integer,Integer> inTree) {
		
		if (preStart > preEnd || inStart > inEnd)
			return null;
		Node root = new Node (preOrder[preStart]);
		
		int inRoot = inTree.get(root.data);
		int numsLeft = inRoot - inStart;
		
		root.left = buildBinaryTree(preOrder, preStart+1, preStart + numsLeft, inOrder, inStart, inRoot - 1, inTree);
		root.right = buildBinaryTree(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, inTree);
		
		return root;
		
		
	}
	public static void main(String args[]) {
		 int[] inOrder = {40,20,50,10,60,30};
		 int [] preOrder = {10,20,40,50,30,60};
		 
		 buildTree BT = new buildTree();
		 Node answer = BT.buildBinaryTree(preOrder, inOrder);
		
		 BFS_Tree LO = new BFS_Tree();
		 LO.levelOrderTraversal(answer);
	}

}
