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
	}
	
	private Map<N, DNode<N>> generateDNodes(Graph<N,E> g) {
		Map<N, DNode<N>> resultMap = new HashMap<N, DNode<N>>();
		for(N n : g.getNodes()) {
			resultMap.put(n, new DNode(n));
		}
		
		return resultMap;
	}
	
	private List<DNode<N>> Q = new ArrayList<DNode<N>>(); 
	
	public void run() {
		DNode<N> sNode = dNodeMap.get(startNode);
		dNodeMap.remove(startNode);
		sNode.setDist(0);
		
		Q.add(sNode);
		
		while(!Q.isEmpty()) {
			DNode<N> currN = getSmallestDistanceDNode();
			//N n = ;
			
			for(N node : g.getAdjoiningNodes(currN.getToNode())) {
				int alt = currN.getDist() + g.getDistance(currN.getToNode(), node); //uzuppelnic
				
				DNode v = dNodeMap.get(node);
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
	
	private DNode<N> getSmallestDistanceDNode() {
		int min = Integer.MAX_VALUE;
		DNode minDNode = null;
		for(DNode d : Q) {
			if(d.getDist() < min) {
				min = d.getDist();
				minDNode = d;
			}
		}
		Q.remove(minDNode);
		minDNode.setVisited(true);
		return minDNode;
	}
	
	
	class DNode<N> {
		public N getToNode() {
			return toNode;
		}

		public void setToNode(N toNode) {
			this.toNode = toNode;
		}

		public int getDist() {
			return dist;
		}

		public void setDist(int dist) {
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
		public int dist = Integer.MAX_VALUE;
		public boolean visited = false;
		public N prev = null;
		
		public DNode(N node) {
			toNode = node;
			
		}
	}
	
}
