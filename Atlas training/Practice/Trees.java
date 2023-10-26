
public class Trees {
	public static void main(String args[]) {
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
		buildPreOrderTree tree = new buildPreOrderTree();
		Node root = tree.buildTree(nodes);
		System.out.println(root.data);
	}

}
