package Trees;

import java.util.Scanner;

// This is the implementation of DFS Trees.
/*
 * DFS or Depth first search works as per the depth (level/height of the tree).
 * DFS Traversal is of the following types:
 * 1. In Order Traversal (Left, Root, Right)
 * 2. Pre-Order Traversal (Root, Left, Right)
 * 3. Post Order Traversal (Left, Right, Root)
 */
public class DFS_Tree{
	
	Node node;
	Scanner scanner = new Scanner (System.in);
	/*
	public void insertFirstNode(Node node) {
		if (node == null) {
			System.out.println("Enter data");
			int data = Integer.parseInt(scanner.nextLine());
			Node node1 = new Node(data);
			
			node = node1;
		}
		
		else
			return;
	}
	
	// Insert Node to the left
	public void insertNodeToLeft(Node node) {
		
		insertFirstNode(node);
		
		System.out.println("Enter the data you want to insert to the left");
		int data = Integer.parseInt(scanner.nextLine());
		
		Node start;
		start = node;
		
		while (start.left!= null) {
			start = start.left;
		}
		
		Node newNode = new Node(data);
		
		start.left = newNode;
		
	}
	
	// Insert Node to the right
	public void insertNodeToRight(Node node) {
		
		insertFirstNode(node);
		System.out.println("Enter the data you want to insert to the left");
		int data = Integer.parseInt(scanner.nextLine());
		
		Node start;
		start = node;
		
		while (start.right!= null) {
			start = start.right;
		}
		
		Node newNode = new Node(data);
		
		start.right = newNode;
		
	}
	*/	
	public void InOrderTraversal (Node node) {
		
		
		if (node == null)
			return;
		// Traversing to the left node
		InOrderTraversal(node.left);
		// Displaying the left node
		System.out.print(node.data+" ");
		// Store the value and return if you want
		
		// Traversing to the right node
		InOrderTraversal(node.right);
		
	}
	
	public void PreOrderTraversal(Node node) {
		
		if (node == null)
			return;

		// Display the root
		System.out.print(node.data+" ");
		
		// Traverse to the left
		PreOrderTraversal(node.left);
		
		// Traverse to the right
		PreOrderTraversal(node.right);
		
	}
	
	public void PostOrderTraversal(Node node) {
		
		if (node == null)
			return;
		// Traverse to the left
		PostOrderTraversal(node.left);
		
		// Traverse to the right
		PostOrderTraversal(node.right);
		
		// Display the root
		System.out.print(node.data+" ");
	}
	
	public static void main(String args[]) {
		DFS_Tree tree = new DFS_Tree();
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
        // tree.node.right.left.right = new Node(9);
        tree.node.right.right.left = new Node(10);
        tree.node.right.right.right = new Node(11);
		
        System.out.print("PreOrder Traversal is: ");
        tree.PreOrderTraversal(tree.node);
        
        System.out.println();
        System.out.print("PostOrder Traversal is:");
        tree.PostOrderTraversal(tree.node);
        System.out.println();
        System.out.print("InOrder Traversal is: ");
        tree.InOrderTraversal(tree.node);
		
	}
	
}
