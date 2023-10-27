package com.amazon.atlas22.datastructures;

import com.amazon.atlas22.model.Node;

public class BinarySearchTree {
	
	int size;
	Node rootNode; 
	Node lastAddedNode;

	public BinarySearchTree(){
		System.out.println("[BinarySearchTree] Created with size: "+size+" and rootNode as "+rootNode);
	}
	
	public Node insert(int data) {
		
		size++; 
		// Create a Node at any cost
		Node node = new Node(data);
		
		if(rootNode == null) {	
			rootNode = node;
			System.out.println("[BinarySearchTree] Root Node Added: "+rootNode+" and size is: "+size);
			rootNode.showNode();
		}
		
		return null;
		
	}
	
}
