package com.amazon.atlas22.model;

public class Node {
	
	public int data;
	public Node left;
	public Node right;
	
	public Node() {
		this(0);
	}
	
	public Node(int data) {
		System.out.println("[Node] Object Created with data: "+data);
		this.data = data;
		left = null;
		right = null;
	}

	public void showNode() {
		String nodeDetails = "[Node] data=" + data + ", left=" + left + ", right=" + right;
		System.out.println(nodeDetails);
	}
	
}
