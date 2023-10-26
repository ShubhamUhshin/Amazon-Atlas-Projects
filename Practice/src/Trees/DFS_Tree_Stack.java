package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class DFS_Tree_Stack {
	Stack <Node> treeElement = new Stack<>();
	ArrayList <Integer> List = new ArrayList<>();
	
	Node node;
	
		
	public ArrayList<Integer> PreOrder(Node node){
			
		List.clear();
		treeElement.clear();
		Node treeNode = node;
		if (treeNode == null)
			return List; 
		
		treeElement.push(treeNode);
		while (!treeElement.isEmpty()) {
			
			treeNode = treeElement.pop();
			List.add(treeNode.data);
			
			if (treeNode.right != null)
				treeElement.push(treeNode.right);
			
			if (treeNode.left !=null)
				treeElement.push(treeNode.left);
			
		}
		
		return List;
	}
	
	public ArrayList<Integer> InOrder(Node node){
		List.clear();
		treeElement.clear();
		
		Node TreeNode = node;
		
		while (true) {
			if (TreeNode !=null) {
				treeElement.push(TreeNode);
				TreeNode = TreeNode.left;
			}
				else {
					if (treeElement.isEmpty()) {
						break;
					}
					TreeNode = treeElement.pop();
					List.add(TreeNode.data);
					TreeNode = TreeNode.right;
				}
				
		}
		
		return List;
	}
	
	public ArrayList<Integer> PostOrder(Node node){
		
		Stack<Node> temp = new Stack<>();
		
		List.clear();
		treeElement.clear();
		Node treeNode = node;
		temp.add(treeNode);
		
		while (!temp.isEmpty()) {
			treeNode = temp.pop();
			treeElement.push(treeNode);
			if (treeNode.left != null)
				temp.push(treeNode.left);
			
			if (treeNode.right!=null)
				temp.push(treeNode.right);
		}
		
		while (!treeElement.isEmpty())
			List.add(treeElement.pop().data);
		
		return List;
	}
	
	// PostOrder using 1 stack
	public ArrayList<Integer> postOrderOneStack (Node node){
		
		List.clear();
		treeElement.clear();
		Node treeNode = node;
		Node tempNode;
		
		while (treeNode != null || !treeElement.isEmpty()) {
			if (treeNode != null) {
				treeElement.push(treeNode);
				treeNode = treeNode.left;
			}
			
			else {
				tempNode = treeElement.peek().right;
				if (tempNode == null) {
					tempNode = treeElement.pop();
					List.add(tempNode.data);
					while (!treeElement.isEmpty() && tempNode == treeElement.peek().right) {
						tempNode = treeElement.pop();
						List.add(tempNode.data);
					}
				}
				
				else {
					treeNode = tempNode;
				}
			}
		}
		return List;
	}
	
	public void Traversal (Node node) {
		
		Stack <Pair> tree = new Stack<>();
		ArrayList <Integer> preOrderList = new ArrayList<>();
		ArrayList<Integer> InOrderList = new ArrayList<>();
		ArrayList <Integer> postOrderList = new ArrayList<>();
		treeElement.clear();
		
		Node TreeNode = node;
		
		if (TreeNode == null)
			System.out.println("Empty tree");
		
		tree.push(new Pair(TreeNode,1));
		
		while (!tree.isEmpty()) {
			
			Pair element = tree.pop();
			
			if (element.value == 1) {
				preOrderList.add(element.key.data);
				element.value += 1;
				tree.push(element);
				
				if (element.key.left != null)
					tree.push(new Pair(element.key.left,1));
			}
			
			else if(element.value == 2) {
				InOrderList.add(element.key.data);
				element.value += 1;
				tree.push(element);
				
				if (element.key.right != null)
					tree.push(new Pair(element.key.right,1));
			}
			
			else {
				postOrderList.add(element.key.data);
			}
		}
		
		System.out.println();
		System.out.print("Pre Order List:\t");
		for (int element : preOrderList)
			System.out.print(element+" ");
		
		System.out.println();
		System.out.print("InOrder List:\t");
        for (int element : InOrderList)
			System.out.print(element+" ");
        
        System.out.println();
        System.out.print("Post Order List: ");
		for (int element : postOrderList)
			System.out.print(element+" ");
				
	}
	
	public static void main(String args[]) {
		DFS_Tree_Stack dfsTree = new DFS_Tree_Stack();
		ArrayList <Integer> preOrderList = new ArrayList<>();
		ArrayList<Integer> InOrderList = new ArrayList<>();
		ArrayList <Integer> postOrderList = new ArrayList<>();
		ArrayList <Integer> postOrderOneStackList = new ArrayList<>();
		DFS_Tree_Stack tree = new DFS_Tree_Stack();
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
		
        preOrderList = dfsTree.PreOrder(tree.node);
        System.out.print("Pre Order List:\t");
		for (int element : preOrderList)
			System.out.print(element+" ");
		
		System.out.println();
		System.out.print("InOrder List:\t");
        InOrderList = dfsTree.InOrder(tree.node);
        for (int element : InOrderList)
			System.out.print(element+" ");
        
		//System.out.println(tree.node.data);
        postOrderList = dfsTree.PostOrder(tree.node);
		System.out.println();
		System.out.print("Post Order List: ");
		for (int element : postOrderList)
			System.out.print(element+" ");
		
		postOrderOneStackList = dfsTree.postOrderOneStack(tree.node);
		System.out.println();
		System.out.print("Post Order List using 1 stack: ");
		for (int element : postOrderOneStackList)
			System.out.print(element+" ");
		
		System.out.println();
		dfsTree.Traversal(tree.node);
		
	}
	
	

}
