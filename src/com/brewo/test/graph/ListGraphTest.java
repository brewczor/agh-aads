package com.brewo.test.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.brewo.graph.Graph;
import com.brewo.graph.ListGraph;

public class ListGraphTest {

	private Graph<String, String> m;
	private String n1;
	private String n2;
	private String n3;
	private String n4;
	private String n5;
	private String n6;
	
	private String e1;
	private String e2;
	private String e3;
	private String e4;
	private String e5;
	private String e6;
	private String e7;
	
	@Before
	public void init() {
		n1 = "node1";
		n2 = "node2";
		n3 = "node3";
		n4 = "node4";
		n5 = "node5";
		n6 = "node6";
		
		e1 = "edgeX";
		e2 = "edge2";
		e3 = "edge3";
		e4 = "edge4";
		e5 = "edge5";
		e6 = "edge6";
	}
	
	@Test
	public void addSameNodeTest() {
		m = new ListGraph<String, String>();
		
		m.addNode(n1);
		m.addNode(n1);
		m.addNode(n1);
		m.addNode(n1);
		m.addNode(n1);
		m.addNode(n1);
		
		Assert.assertEquals(1, m.countNodes());
		
	}
	
	@Test
	public void addDifferentNodeTest() {
		
		
		m = new ListGraph<String, String>();
		
		m.addNode(n1);
		m.addNode(n2);
		m.addNode(n3);
		m.addNode(n4);
		m.addNode(n5);
		m.addNode(n6);
		
		Assert.assertEquals(6, m.countNodes());
		
	}
	
	
	@Test
	public void deleteNodeTest() {
		addDifferentNodeTest();
		
		m.deleteNode(n3);
		m.deleteNode(n1);
		m.deleteNode(n1);
		
		Assert.assertEquals(4, m.countNodes());
	}
	
	@Test
	public void addEdgeTest() {
		addDifferentNodeTest();
		
		m.addEdge(e1, n3, n1, 4);
		m.addEdge(e2, n2, n1, 6);
		
		Assert.assertEquals(6, m.countNodes());
		
		//Assert.assertEquals(2, m.getEdgesCount());
		
		//Assert.assertEquals(2, ((MatrixGraph)m).getEdgesCountFromInside());
		
	}
	
	
	@Test
	public void getAdjoiningNodesTest() {
		addDifferentNodeTest();
		m.addEdge(e1, n1, n2, 4);
		m.addEdge(e2, n1, n1, 3);
		m.addEdge(e1, n1, n1, 5); // ten jest zly
		m.addEdge(e4, n4, n1);
		
		
		Assert.assertEquals(3, m.getEdgesCount());
		Assert.assertEquals(2, m.getAdjoiningNodes(n1).size());
		
	}
	
	@Test
	public void getAdjoiningEdgesTest() {
		addDifferentNodeTest();
		m.addEdge(e1, n1, n2, 4);
		System.out.println("a");
		m.addEdge(e2, n1, n1, 3);
		System.out.println("b");
		m.addEdge(e3, n1, n1, 5);
		System.out.println("c");
		m.addEdge(e4, n4, n1);
		System.out.println("d");
		
		Assert.assertEquals(3, m.getAdjoiningEdges(n1).size());
	}
	
//	@Test
//	public void areNeighboursTest() {
//		m = new ListGraph<String, String>();
//		m.addNode(n1);
//		m.addNode(n2);
//		
//		m.addEdge(e1, n1, n2);
//		
//		Assert.assertEquals(true, m.areNeighbours(n1, n2));
//		
//		Assert.assertEquals(false, m.areNeighbours(n2, n1));
//	}
	


}
