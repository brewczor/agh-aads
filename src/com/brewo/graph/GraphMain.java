package com.brewo.graph;

public class GraphMain {
	private String n1;
	private String n2;
	private String n3;
	private String n4;
	private String n5;
	private String n6;
	
	public GraphMain() {
		
	}
	public static void main(String[] args) {
		
	}
	
	
	public void matrixGraphSimpleTest() {
		MatrixGraph<String, String> m = new MatrixGraph<>();
		m.addNode("node1");
		m.addNode("node2");
		m.addNode("node3");
		m.addNode("node4");
		
		m.addEdge("edge2", "node2", "node3", 2);
		
		m.addEdge("edge1", "node2", "node1", 1);
		System.out.println(((MatrixGraph)m).getEdgesCountFromInside());
		
		System.out.println(m);
	}
}
