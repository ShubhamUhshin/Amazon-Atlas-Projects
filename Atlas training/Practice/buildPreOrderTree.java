
public class buildPreOrderTree{
	
	static int idx = -1;
	
	public int buildTree(int[] nodes){
		
		idx++;
		Node newNode = new Node(nodes[idx]);
		if (nodes[idx] == -1)
			return null;
		
		else {
		
			newNode.leftNode = buildTree(nodes);
			newNode.rightNode = buildTree(nodes);
			
			return newNode;
		}
	}
}
