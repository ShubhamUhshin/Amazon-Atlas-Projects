package com.amazon.atlas22.datastructures;

import java.util.LinkedList;

public class Graph {
	
	// Number of Vertices in the Graph
	int v; 
	
	// Adjacent Matrix
	int[][] adjMatrix;

	// Adjacent List => Array of LinkedLists :)
	LinkedList<Integer>[] adjList;
	
	public Graph(int v) {
		this.v = v;
		adjMatrix = new int[v][v];
		adjList = new LinkedList[v];
		
		// Initialize all the LinkedLists
		for(int i=0;i<adjList.length;i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("[Graph] Created with "+v+" vertices");
		System.out.println("[Graph] "+(v*v)+" Adj Matrix");
		System.out.println("[Graph] "+v+" Adj Lists");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void addEdge(int v1, int v2) {
		System.out.println("[Graph] Adding an Edge Between: vertex "+v1+" and vertex "+v2);
		
		// Update Edge from v1 to v2 in Matrix
		adjMatrix[v1][v2] = 1;
		
		// Update Edge from v2 to v1 in Matrix
		adjMatrix[v2][v1] = 1;
		
		// Update Edge from v1 to v2 in List
		adjList[v1].add(v2);
		// Update Edge from v2 to v1 in List
		adjList[v2].add(v1);
		
	}
	
	public void printAdjMatrix() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Adj Matrix");
		for(int i=0;i<adjMatrix.length;i++) {
			System.out.print(i+"| ");
			for(int j=0;j<adjMatrix[i].length;j++) {
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void printAdjList() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Adj List");
		for(int i=0;i<adjList.length;i++) {
			System.out.print(i+"| ");
			for(int element : adjList[i]) {
				System.out.print(element+" ");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void printEdgeList() {
		
	}
	
}
