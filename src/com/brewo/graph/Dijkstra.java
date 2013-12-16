package com.brewo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brewo.graph.Dijkstra.DNode;

// jaka jest dlugosc od 1 do 88 (waga)
public class Dijkstra<N, E> {

	Graph<N,E> g;
	
	N startNode;
	Map<N, DNode<N>> dNodeMap;
	//List<DNode<N>> dNodeList = null;
	
	public Dijkstra(Graph<N,E> g, N sNode) {
		this.g = g;
		startNode = sNode;
		dNodeMap = generateDNodes(g);
		
//		for(N n : dNodeMap.keySet()) {
//			System.out.println(n);
//		}
	}
	
	private Map<N, DNode<N>> generateDNodes(Graph<N,E> g) {
		Map<N, DNode<N>> resultMap = new HashMap<N, DNode<N>>();
		for(N n : g.getNodes()) {
			resultMap.put(n, new DNode<N>(n));
		}
		
		return resultMap;
	}
	
	private List<DNode<N>> Q = new ArrayList<DNode<N>>(); 
	
	public void run() {
		DNode<N> sNode = dNodeMap.get(startNode);
		dNodeMap.remove(startNode);
		
		sNode.setDist(0);
		//sNode.setVisited(true);
		Q.add(sNode);
		
		while(!Q.isEmpty()) {
			DNode<N> currN = getSmallestDistanceDNode();
			//N n = ;
			
			for(N node : g.getAdjoiningNodes(currN.getToNode())) {
				double alt = currN.getDist() + g.getDistance(currN.getToNode(), node); //uzuppelnic
				//System.out.println("Distance:" + alt);
				//System.out.println("|" + node + "|");
				DNode v = dNodeMap.get(node);
				if(v != null) {
				if(alt < v.getDist()) {
					v.setDist(alt);
					v.setPrev(currN.getToNode());
					if(!v.visited) {
						Q.add(v);
					}
				}
				}
			}
		}
		
		printResult();
		
	}
	
	private void printResult() {
		for(DNode<N> d : dNodeMap.values()) {
			System.out.println("d node: " + d.getToNode() + " dist: " + d.getDist());
		}
	}
	private DNode<N> getSmallestDistanceDNode() {
		double min = Double.POSITIVE_INFINITY;
		DNode<N> minDNode = null;
		for(DNode<N> d : Q) {
			//System.out.println("min: " + min);
			//System.out.println("d.getDist" + d.getDist());
			//System.out.println(d.getDist() <= min);
			//System.out.println(d.visited);
			if(d.getDist() <= min && !d.visited) {
				min = d.getDist();
				minDNode = d;
			}
		}
		
		//minDNode.setVisited(true);
		Q.remove(minDNode);
		
		return minDNode;
	}
	
	
	class DNode<N> {
		public N getToNode() {
			return toNode;
		}

		public void setToNode(N toNode) {
			this.toNode = toNode;
		}

		public double getDist() {
			return dist;
		}

		public void setDist(double dist) {
			this.dist = dist;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public N getPrev() {
			return prev;
		}

		public void setPrev(N prev) {
			this.prev = prev;
		}

		public N toNode = null;
		public double dist = Double.MAX_VALUE;
		public boolean visited = false;
		public N prev = null;
		
		public DNode(N node) {
			toNode = node;
			
		}
	}
	
}
