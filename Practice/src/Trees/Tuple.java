// This class is created for Vertical Traversal Problem.
// We have a node, a row, a column.
// We store the vertical level of the node, the horizontal level of the node.

package Trees;

public class Tuple {
	
	Node node;
	int row;
	int column;
	
	public Tuple() {
		// TODO Auto-generated constructor stub
	}

	public Tuple(Node node, int row, int column) {
		this.node = node;
		this.row = row;
		this.column = column;
	}
}
