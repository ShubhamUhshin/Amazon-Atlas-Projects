package com.amazon.atlas22.datastructures;

import com.amazon.atlas22.model.Node;

/*
 	
 	BF -> H(TR) - H(TR)
 	-1	:	Left Tree is at 1 level lower than Right Tree
 	0	:	Left Tree is at same level as Right Tree is
 	1	:   Left Tree is at 1 level up than Right Tree
 	
 	
 	In order to Balance the Tree, we need to rotate it
 	Based on certain criteria....
 	
 	When to Rotate ? -> If balance factor is not -1, 0 or 1
 	
 	Rotation Techniques
 	1. Right Rotation 		-> UnBalance where Tree is skewed towards the left  (node is inserted in the left of subtree)
 	2. Left Rotation  		-> UnBalance where Tree is skewed towards the right (node is inserted in the right of subtree)
 	3. Left Right Rotation 	-> UnBalance where Tree forms a Left Triangle  | We need Left Rotation first and then right rotation
 	3. Right Left Rotation 	-> UnBalance where Tree forms a Right Triangle | We need Right Rotation first and then left rotation
 	
 */

public class AVLTree {

	int size;
	Node rootNode; 

	public AVLTree(){
		System.out.println("[AVLTree] Created at "+this+" with size: "+size+" and rootNode as "+rootNode);
	}
	
	public Node insert(Node node, int data) {
		
		if(node == null) {
			// Create a new Node Object
			node = new Node(data);
			size++; 

			if(size == 1) {
				// Allocate the rootNode
				rootNode = node;
			}
			return node;
		}
		
		// Work only with unique elements
		if(data < node.data) { // insert in the left
			node.left = insert(node.left, data);			
		}else if (data > node.data) {				// insert in the right
			node.right = insert(node.right, data);
		}else {
			return node; // do not add duplicate data :)
		}
		
		System.out.println("[AVLTree] [Insert] Node Added: "+node+" and size is: "+size);
		node.showNode();
		
		// Capture the Height from Left and Right and simply add 1 to the height
		// Update the height for the ancestor node: get max height and add 1 :)
		node.height = getMaxHeight(height(node.left), height(node.right)) + 1;
		
		int balance = balanceFactor(node);
		System.out.println("[AVLTree] [Insert] Balance Factor for "+node.data+" is: "+balance);
		
		// Write the 4 Cases in Code so as to perfrom rotations
		
		
		
		//lastAddedNode = node;
		return node;
				
	}

	public int getSize() {
		return size;
	}

	public Node getRootNode() {
		return rootNode;
	}
	
	public void inOrder(Node root) {
		if(root!=null) {
			inOrder(root.left);			  	  // Print/Visit left of the Root
			System.out.print(root.data+" ");  // Print/Visit Root First
			inOrder(root.right);			  // Print/Visit right of the Root
		}
	}
	
	// Iterate in the left subtree
	public int minimum(Node root) {
		int min = root.data;
		
		Node temp = root;
		
		while(temp.left != null) {
			min = temp.left.data;
			temp = temp.left;
		}
		
		return min;
	}
	
	// Iterate in the right subtree
	public int maximum(Node root) {
		int max = root.data;
		
		Node temp = root;
		
		while(temp.right != null) {
			max = temp.right.data;
			temp = temp.right;
		}
		
		return max;
	}
	
	// Return height of Tree
	int height(Node node) {
		
		if(node != null) {
			return node.height;
		}
		
		return 0;
	}
	
	int balanceFactor(Node node) {
		if(node == null)
			return 0;
		
		return height(node.left) - height(node.right);
	}
	
	int getMaxHeight(int leftHeight, int rightHeight) {
		int maxHeight = leftHeight > rightHeight ? leftHeight : rightHeight;
		return maxHeight;
	}
	
	// Method to Rotate the Tree to the Right
	Node rightRotate(Node node) {
		
		return null;
	}
	
	// Method to Rotate the Tree to the Left
	Node leftRotate(Node node) {
		
		return null;
	}
	
}
