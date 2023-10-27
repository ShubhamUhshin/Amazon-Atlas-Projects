package com.amazon.atlas22.datastructures;

import java.util.LinkedList;
import java.util.TreeMap;

class Vertex<T>{
	
	T vertex;
	Integer weight;
	
	public Vertex() {
		// TODO Auto-generated constructor stub
	}

	public Vertex(T vertex, Integer weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Vertex [vertex=" + vertex + ", weight=" + weight + "]";
	}
	
}

class Edge<T>{
	
	Vertex<T> vertex1;
	Vertex<T> vertex2;
	Integer weight;
	
	public Edge() {
		// TODO Auto-generated constructor stub
	}

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2, Integer weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
	}
	
}


public class WeightedGraph<T> {

	// G(V,E)
	TreeMap<Vertex<T>, LinkedList<Vertex<T>>> map;
	LinkedList<Edge<T>> edgeList;
	
	boolean isDirected;
	
	public WeightedGraph() {
		map = new TreeMap<>();
		edgeList = new LinkedList<>();
		isDirected = false;
		System.out.println("[Graph] Created...");
	}
	

	private void addVertex(Vertex<T> vertex) {
		map.put(vertex, new LinkedList<>());
	} 
	
	public void setIsDirected() {
		isDirected = true;
	}
	
	public void addEdge(Edge<T> edge) {
		
		edgeList.add(edge);
		
		System.out.println("[Graph] Adding Edge: "+edge);
		
		if(!map.containsKey(edge.vertex1)) {
			addVertex(edge.vertex1);
		}
		
		if(!map.containsKey(edge.vertex2)) {
			addVertex(edge.vertex2);
		}
		
		// Obtain the Adj List of the vertext1 and add vertex2 inside it :)
		map.get(edge.vertex1).add(edge.vertex2);
		
		if(!isDirected)
			// In Case Graph is undirected, add other way around as well :)
			map.get(edge.vertex2).add(edge.vertex1);
	}
	
	public void printAdjList() {
		
		for(Vertex<T> key : map.keySet()) { // Get the Keys and Iterate in them
			LinkedList<Vertex<T>> adjList = map.get(key);
			
			System.out.println("-------------------");
			System.out.println("Adj List of "+key);
			for(Vertex<T> vertex : adjList) {
				System.out.println(vertex);
			}
			System.out.println("-------------------");
			System.out.println();
			
		}
		
	}
	
	public int vertices() {
		return map.size();
	}
	
}
