/*
 *  Find the nearest greatest number to a given key in a BST
 *  For eg, say the tree is 
 *  								10
 *  				5							13
 *  			3		6					11		14
 *  		2		4		9
 *  
 *  Key = 8
 *  Answer = 9.
 *  
 *  Say Key = 11
 *  Answer = 11
 */

package BST;

import Trees.Node;

public class CeilNumber {
	Node treeNode;
	
	public int findCeil (Node treeNode, int key, int ceil) {
		if (treeNode == null)
			return ceil;
		
		if (treeNode.data == key)
			return treeNode.data;
		
		else {
			if (treeNode.data < key)
				ceil = findCeil(treeNode.right,key,ceil);
			
			else {
				ceil = treeNode.data;
				ceil = findCeil(treeNode.left, key, ceil);
			}
		}
		return ceil;
	}
	
	public static void main (String args[]) {
		
		CeilNumber CN = new CeilNumber();
		CN.treeNode = new Node(10);
		CN.treeNode.left = new Node(5);
		CN.treeNode.right = new Node(13);
		CN.treeNode.left.left = new Node(3);
		CN.treeNode.left.right = new Node(6);
		CN.treeNode.left.left.left = new Node(2);
		CN.treeNode.left.left.right = new Node(4);
		CN.treeNode.left.right.right = new Node(9);
		CN.treeNode.right.left = new Node(11);
		CN.treeNode.right.right = new Node(14);
		
		System.out.println(CN.findCeil(CN.treeNode, 12, -1));
	}

}
