package com.amazon.atlas22.model;

public class GenericNode<T> {
	
	public T data; // data in tree can be any type :)
	public int height;
	public Node left;
	public Node right;
	
	public GenericNode() {
		this(null);
	}
	
	public GenericNode(T data) {
		System.out.println("[GenericNode] Object Created at "+this+" with data: "+data);
		this.data = data;
		height = 1;
		left = null;
		right = null;
	}

	public void showNode() {
		String nodeDetails = "[GenericNode] data=" + data + ", left=" + left + ", right=" + right;
		System.out.println(nodeDetails);
	}
}
