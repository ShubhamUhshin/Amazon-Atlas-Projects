package com.amazon.atlas22.datastructures;

import com.amazon.atlas22.model.Node;

public class GenericAVLTree<T> {
	int size;
	Node rootNode; 

	public GenericAVLTree(){
		System.out.println("[GenericAVLTree] Created at "+this+" with size: "+size+" and rootNode as "+rootNode);
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
		
		// Write the 4 Cases in Code so as to perform rotations
		
		// 1. Left Left Case :) 
		if(balance > 1 && data < node.left.data) {
			System.out.println("[AVLTree] [Insert] CASE1: Left Left Case | Right Rotation Required");
			// Perform Right rotation
			return rightRotate(node);
		}
		
		// 2. Right Right Case :)
		if(balance < -1 && data > node.right.data) {
			System.out.println("[AVLTree] [Insert] CASE2: Right Right Case | Left Rotation Required");
			// Perform Left rotation
			return leftRotate(node);
		}
		
		// 3. Left Right Case :)
		if(balance > 1 && data > node.left.data) {
			System.out.println("[AVLTree] [Insert] CASE2: Left Right Case | Left Rotation > Right Rotation Required");
			// Perform Left rotation and then Right Rotation
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		// 4. Right Left Case :)
		if(balance < -1 && data < node.right.data) {
			System.out.println("[AVLTree] [Insert] CASE2: Right Left Case | Right Rotation > Left Rotation Required");
			// Perform Left rotation and then Right Rotation
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
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
	
	Node rightRotate(Node y) {
		
		Node x = y.left;
		Node T2 = x.right;
		
		// Perform Rotation
		x.right = y;
		y.left = T2;
		
		// Update Heights :)
		y.height = getMaxHeight(height(y.left), height(y.right)) + 1;
		x.height = getMaxHeight(height(x.left), height(x.right)) + 1;
		
		// New Root 
		return x;
	}
	
	Node leftRotate(Node x) {

		Node y = x.right;
		Node T2 = y.left;
		
		// Perform Rotation
		y.left = x;
		x.right = T2;
		
		// Update Heights :)
		x.height = getMaxHeight(height(x.left), height(x.right)) + 1;
		y.height = getMaxHeight(height(y.left), height(y.right)) + 1;
		
		return y;
	}
}
