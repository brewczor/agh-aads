package com.brewo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Wlozyc nody do edga a nastepnie edge do graphu :)
 * 
 * Trzymac tylko edge wychodzące z wierzcholka
 * 
 * wez poprzedniki wez nastepniki dorobic
 */
public class ListGraph<N, E> implements Graph<N, E> {

	Map<E, Edge<N, E>> edgeMap;
	Map<N, List<E>> neigMap;

	public ListGraph() {
		edgeMap = new HashMap<E, Edge<N, E>>();
		neigMap = new HashMap<N, List<E>>();
	}

	@Override
	public void addNode(N n) {
		if (n == null || neigMap.containsKey(n)) {
			return;
		}

		neigMap.put(n, new ArrayList<E>());

	}

	@Override
	public void deleteNode(N n) {
		if (n == null || !neigMap.containsKey(n)) {
			return;
		}

		// removing edges which ends in node n
		for (List<E> edgeL : neigMap.values()) {
			for (E edge : edgeL) {
				if (edgeMap.get(edge).getToNode().equals(n)) {
					edgeL.remove(edge);
				}
			}
		}

		// removing edges from edgeMap
		List<E> edgeL = neigMap.get(n);
		for (E edge : edgeL) {
			edgeMap.remove(edge);
		}

		// removing Node
		neigMap.remove(n);
	}

	@Override
	public int countNodes() {
		return neigMap.size();
	}

	@Override
	public int countEdges() {
		return edgeMap.size();
	}

	@Override
	public void addEdge(E e, N n1, N n2) {
		addEdge(e, n1, n2, 1);
	}

	@Override
	public void addEdge(E e, N n1, N n2, int weight) {
		if (n1 == null || n2 == null || e == null || edgeMap.containsKey(e)) {
			return;
		}
		System.out.println(n1 + "->" + n2 + "|" + e);
		if (!neigMap.containsKey(n1)) {
			
			addNode(n1);
		}

		
		neigMap.get(n1).add(e);
		edgeMap.put(e, new MyEdge<N, E>(e, n1, n2, weight));
	}

	@Override
	public void deleteEdge(E e) {
		if(e == null) {
			return;
		}
		
		N fromNode = edgeMap.get(e).getFromNode();
		
		neigMap.get(fromNode).remove(e);
		
		edgeMap.remove(e);
	}

	@Override
	public List<N> getAdjoiningNodes(N n) {
		if(n == null) {
			return null;
		}
		
		List<N> resultList = new ArrayList<N>();
		System.out.println(neigMap.get(n));
		for(E edge : neigMap.get(n)) {
			N node = edgeMap.get(edge).getToNode();
			if(!resultList.contains(node))
				resultList.add(node);
		}

		return resultList;
	}

	@Override
	public List<E> getAdjoiningEdges(N n) {
		if(n == null) {
			return null;
		}
		
		return neigMap.get(n);
	}

//	public List<E> getAdjInEdges(N n) {
//		return neigMap.get(n).getInList();
//	}
//
//	public List<E> getAdjOutEdges(N n) {
//		return neigMap.get(n).getOutList();
//	}
	
	@Override
	public boolean containsNode(N n) {
		return neigMap.containsKey(n);
	}
	
	
	@Override
	public boolean containsEdge(E e) {
		return edgeMap.containsKey(e);
	}

	@Override
	public Edge<N,E> getEdgeEnds(E e) {
		if(e == null) {
			return null;
		}
		
		return edgeMap.get(e);
	}

	@Override
	public int getNodesCount() {
		return neigMap.size();
	}

	@Override
	public int getEdgesCount() {
		return edgeMap.size();
	}

	@Override
	public boolean areNeighbours(N n1, N n2) {
		if(n1 == null || n2 == null) {
			return false;
		}
		
		List<E> edgeL = neigMap.get(n1);
		for(E edge : edgeL) {
			if(edgeMap.get(edge).getToNode().equals(n2))
				return true;
		}
		
		return false;
	}

	@Override
	public List<N> getNodes() {
		List<N> resultList = new ArrayList<N>();
		for(N n : neigMap.keySet()) {
			resultList.add(n);
		}
		return resultList;
	}

}
