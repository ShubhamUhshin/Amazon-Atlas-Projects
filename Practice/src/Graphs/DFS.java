package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
	
	public void findDFS (int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfsTraverse) {
		
		vis [node] = true;
		dfsTraverse.add(node);
		
		for (Integer it : adj.get (node)) {
			
			if (vis [it] == false)
				findDFS (it,adj,vis,dfsTraverse);
		}
	}
	public ArrayList<Integer> dfsOfGraph (int V, ArrayList<ArrayList<Integer>> adj){
		
		
		boolean vis[] = new boolean [V+1];
		vis [0] = true;
		ArrayList<Integer> dfsTraverse = new ArrayList<>();
		findDFS (0,adj,vis,dfsTraverse);
		return dfsTraverse;
	}
}
