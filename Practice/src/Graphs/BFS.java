// BFS Traversal of a graph.
// SC- O(N) ignoring the adjacency list
// TC - O(N) + O(2E) where E is the edges

package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public ArrayList<Integer> findBFS (int V, ArrayList<ArrayList<Integer>> adj){
		
		ArrayList <Integer> bfs = new ArrayList<>();
		Queue <Integer> q = new LinkedList<>();
		boolean vis [] = new boolean[V];
		
		q.add(0);
		vis[0] = true;
		
		while (!q.isEmpty()) {
			
			Integer val = q.poll();
			bfs.add(val);
			
			for (Integer i : adj.get(val)) {
				
				if (!vis[i]) {
					vis[i] = true;
					q.add (i);
				}
				
			}
		}
		
		return bfs;
		
		
	}
	
	public static void main(String args[]) {
		
	}

}
