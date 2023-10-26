// Children Sum Property
/*
 *  The Idea of the problem is that the Given a binary tree, the task 
 *  is to check for every node, its value is equal to the sum of values 
 *  of its immediate left and right child. For NULL values, consider 
 *  the value to be 0.
 *  
 *  The solution mentioned in any sheet/explanation is O(n*n)
 *  We will  solve it in O(n)
 */

/*
 * In the general bottom up approach of the tree, if the root node is
 * greater than the sum of left and right child, we are getting stuck
 * as the value of the node cannot be decreased in this problem statement.
 * So, we use recursion and we keep on checking if the sum of the left
 * and right child is greater than the parent, we assign the summed value
 * to the parent, else the value of the parent to both the children. Due
 * to this, we will never be short of values.
 */

package Trees;

public class ChildrenSum {
	
	Node treeNode;
	public void childrenSumProperty(Node treeNode) {
		
		// The base condition
		if (treeNode == null)
			return;
		
		// To find the sum of the left and right child
		int child = 0;
		if (treeNode.left != null)
			child += treeNode.left.data;
		
		if (treeNode.right != null)
			child += treeNode.right.data;
		
		if (child >= treeNode.data)
			treeNode.data = child;
		
		else {
			if (treeNode.left != null)
				treeNode.left.data = treeNode.data;
			
			else if (treeNode.right != null)
				treeNode.right.data = treeNode.data;
		}
		
		
		childrenSumProperty(treeNode.left);
		childrenSumProperty(treeNode.right);
		
		int total = 0;
		if (treeNode.left != null)
			total += treeNode.left.data;
		
		if (treeNode.right != null)
			total += treeNode.right.data;
		
		if (treeNode.left != null || treeNode.right != null)
			treeNode.data = total;
		
	}

	public static void main(String args[]) {
		ChildrenSum csp = new ChildrenSum();
		
		csp.treeNode = new Node (2);
		csp.treeNode.left = new Node (35);
		csp.treeNode.right = new Node (10);
		csp.treeNode.left.left = new Node (2);
		csp.treeNode.left.right = new Node (3);
		csp.treeNode.right.left = new Node (5);
		csp.treeNode.right.right = new Node (2);
		
		csp.childrenSumProperty(csp.treeNode);
		DFS_Tree tree = new DFS_Tree();
		tree.InOrderTraversal(csp.treeNode);
		
	}
}
