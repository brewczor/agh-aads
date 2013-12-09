package com.brewo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representation of graph - matrix version
 * 
 * @author Lukas
 * 
 * @param <N>
 * @param <E>
 */
public class MatrixGraph<N, E> implements Graph<N, E> {

	Map<E, Edge<N, E>> edgeMap;
	Map<N, Map<N, List<E>>> matrix;

	public MatrixGraph() {
		edgeMap = new HashMap<E, Edge<N, E>>();
		matrix = new HashMap<N, Map<N, List<E>>>();
	}

	@Override
	public void addNode(N n) {
		if (n != null && !matrix.containsKey(n)) {
			matrix.put(n, new HashMap<N, List<E>>());
		}
	}

	@Override
	public int countNodes() {
		return matrix.size();
	}

	@Override
	public int countEdges() {
		return edgeMap.size();
	}

	@Override
	public void deleteNode(N n) {
		if (n == null || !matrix.containsKey(n)) {
			return;
		}

		// removing insideMap nodes & edges from edgeMap
		for (Map<N, List<E>> innerMap : matrix.values()) {
			if (innerMap.containsKey(n)) {
				List<E> edgeL = innerMap.get(n);
				for (E edge : edgeL) {
					edgeMap.remove(edge);
				}
				innerMap.remove(n);
			}
		}

		// removing inside Map values
		Map<N, List<E>> map = matrix.get(n);
		for (List<E> edgeL : map.values()) {
			for (E edge : edgeL) {
				if (edgeMap.containsKey(edge)) {
					edgeMap.remove(edge);
				}
			}
		}

		matrix.remove(n);

	}

	public void addEdge(E e, N n1, N n2) {
		addEdge(e, n1, n2, 1);
	}

	@Override
	public void addEdge(E e, N n1, N n2, int weight) {
		if (e == null || containsEdge(e))
			return;

		if (!matrix.containsKey(n1)) {
			addNode(n1);
		}

		if (!matrix.containsKey(n2)) {
			addNode(n2);
		}

		if (!matrix.get(n1).containsKey(n2)) {
			matrix.get(n1).put(n2, new ArrayList<E>());
		}

		matrix.get(n1).get(n2).add(e);
		edgeMap.put(e, new MyEdge<N, E>(e, n1, n2, weight));

	}

	@Override
	public void deleteEdge(E e) {
		if (e == null || !containsEdge(e)) {
			return;
		}
		
		N n1 = edgeMap.get(e).getFromNode();
		N n2 = edgeMap.get(e).getToNode();
		
		List<E> edgeL = matrix.get(n1).get(n2);
		edgeL.remove(e);
		if(edgeL.isEmpty()) {
			matrix.get(n1).remove(n2);
		}
		
		edgeMap.remove(e);
	}
	
	
	//tu skonczylem
	
	

	//zwraca jeden node w przypadku podwojnych polaczen
	@Override
	public List<N> getAdjoiningNodes(N n) {
		if(n == null || !containsNode(n)) {
			return null;
		}
		
		List<N> resultList = new ArrayList<N>();
		for(N toNode : matrix.get(n).keySet()) {
			resultList.add(toNode);
		}
		
//		for(Map<N, List<E>> innerMap : matrix.values()) {
//			for(N node : innerMap.keySet()) {
//				resultList.add(node);
//			}
//			
//		}
		
		return resultList;

	}

	@Override
	public List<E> getAdjoiningEdges(N n) {
		if(n == null || !containsNode(n)) {
			return null;
		}
		
		List<E> resultList = new ArrayList<E>();
			
		Map<N, List<E>> neighbours = matrix.get(n);
		for (List<E> e : neighbours.values()) {
			resultList.addAll(e);
		}
		
		return resultList;
	}

	@Override
	public boolean containsNode(N n) {
		return matrix.containsKey(n);
	}

	@Override
	public boolean containsEdge(E e) {
		return edgeMap.containsKey(e);
	}

	@Override
	public Edge<N, E> getEdgeEnds(E e) {
		return edgeMap.get(e);
		//Edge resultEdge = edgeMap.get(e);
//		List<N> result = new ArrayList<N>();
//		if (e != null && findEdge(e)) {
//			N begin = null;
//			N end = null;
//			for (N startN : matrix.keySet()) {
//				Map<N, List<E>> m = matrix.get(startN);
//
//				for (N endN : m.keySet()) {
//					List<E> l = m.get(endN);
//					if (l.contains(e)) {
//						begin = startN;
//						end = endN;
//					}
//				}
//			}
//
//			result.add(begin);
//			result.add(end);
//		}
		//return result;
	}

	@Override
	public int getNodesCount() {
		return matrix.keySet().size();
	}

	@Override
	public int getEdgesCount() {
		return edgeMap.size();

	}

	public int getEdgesCountFromInside() {
		int i = 0;
		for (Map<N, List<E>> oMap : matrix.values()) {
			for (List<E> eList : oMap.values()) {
				for (E ed : eList) {
					i++;
				}
			}
		}
		return i;
	}

	@Override
	public boolean areNeighbours(N n1, N n2) {
		boolean areNeighbouring = matrix.get(n1).containsKey(n2);
		return areNeighbouring;
	}

//	public void print() {
//		System.out.println(this);
//		for (N n : matrix.keySet()) {
//			System.out.println(n);
//		}
//		for (E E : edgeList) {
//			System.out.println(E);
//		}
//
//		for (E e : edgeList) {
//			List<N> nList = getEdgeEnds(e);
//			System.out.println(nList.get(0) + "->>>" + nList.get(1));
//		}
//	}

	@Override
	public String toString() {
		return String.format("Matrix Graph with %d %s and %d %s",
				getNodesCount(), getEdgesCount() == 1 ? "vertex" : "verticles",
				edgeMap.size(), edgeMap.size() == 1 ? "edge" : "edges");
	}

	// TODO poprawić metode wyswietlajaca
	public void printGraph() {
		System.out.println("Matrix size: " + matrix.size());

		System.out.print("_____");
		for (int i = 0; i < matrix.size(); i++) {
			System.out.print(i + "_____");
		}

		System.out.println();

		// for(Mapint i = 0; i < matrix.size(); i++) {
		// System.out.print(i+ " ");
		int x = 0;
		for (Map<N, List<E>> m : matrix.values()) {
			System.out.print(m + " ");

			for (List<E> l : m.values()) {
				System.out.print("[ ");
				for (int i = 0; i < l.size(); i++) {
					System.out.print("1 ");
				}
				System.out.print(" ]");
			}

			System.out.println();

		}
	}
	
	@Override
	public List<N> getNodes() {
		List<N> resultList = new ArrayList<N>();
		for(N n : matrix.keySet()) {
			resultList.add(n);
		}
		return resultList;
	}
	
	@Override
	public int getDistance(N n1, N n2) {
		List<E> eList = matrix.get(n1).get(n2);
		
		int min = 0 ;
		for(E e : eList) {
			int w = edgeMap.get(e).getWeight();
			if(w < min) {
				min = w;
			}
		}
		return min;
	}
	
	
//	N begin = null;
//	N end = null;
//	for (N startN : matrix.keySet()) {
//		Map<N, List<E>> m = matrix.get(startN);
//
//		for (N endN : m.keySet()) {
//			List<E> l = m.get(endN);
//			if (l.contains(e)) {
//				begin = startN;
//				end = endN;
//			}
//		}
//	}

}
