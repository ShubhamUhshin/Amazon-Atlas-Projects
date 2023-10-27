package com.amazon.atlas22.graphalgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/*
 	For a MST, we will have V-1 Edges in the Graph :)
 	If their are 7 vertices we must have V-1 i.e. 7-1 as 6 edges in MST :)
 	
 	Rule#1: 
 			Sort all the edges of the Graph in Non Decreasing Order of their weight
 	
 	Rule#2: 
 			2.1 Pick the Smallest Edge and add it in a new Graph (New Graph will be eventually containing edges and vetices with minimum cost)
 			2.2 Ensure their is no cycle getting formed while adding the smallest edge
 				if cycle is getting formed, drop that edge
 				else, add the edge
 				
 				To check cycle in a graph we can use BFS or DFS or | Disjoint Set Union and Find
 				
 		Keep on repeating Step2 unless we have V-1 edges in the Graph which is MST
 */


public class KruskalsAlgorithm {
	
	
	// Merges the 2 Vertices :)
	static void union(int v1, int v2) {
		
	}
	
	// Returns the Absolute Root of Vertex
	static int find(Vertex vertex) {
		
		return 0;
	}
	

	public static void main(String[] args) {
	
		// Consider the ArrayLists as Graph :)
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		Vertex v1 = new Vertex(0);
		Vertex v2 = new Vertex(1);
		Vertex v3 = new Vertex(2);
		Vertex v4 = new Vertex(3);
		Vertex v5 = new Vertex(4);
		Vertex v6 = new Vertex(5);
		
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		
		Edge edge1 = new Edge(0, 1, 1);
		Edge edge2 = new Edge(0, 2, 2);
		Edge edge3 = new Edge(1, 2, 3);
		Edge edge4 = new Edge(1, 3, 1);
		Edge edge5 = new Edge(1, 4, 3);
		Edge edge6 = new Edge(2, 3, 2);
		Edge edge7 = new Edge(2, 4, 1);
		Edge edge8 = new Edge(3, 4, 2);
		Edge edge9 = new Edge(3, 5, 4);
		Edge edge10 = new Edge(4, 5, 3);
		
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);
		edges.add(edge6);
		edges.add(edge7);
		edges.add(edge8);
		edges.add(edge9);
		edges.add(edge10);
		
		// Sorted the Edges based on Weights
		Collections.sort(edges);


	}

}
