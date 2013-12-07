package com.brewo.graph;

public class MyEdge<N, E> implements Edge<N, E>{
	
	N fromNode;
	N toNode;
	int weight;
	
	public MyEdge(N fromNode, N toNode) {
		this(fromNode, toNode, 1);
	}
	
	public MyEdge(N fromNode, N toNode, int weigth) {
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.weight = weigth;
	}
	
	@Override
	public N getFromNode() {
		return fromNode;
	}

	@Override
	public N getToNode() {
		return toNode;
	}

	@Override
	public int getWeight() {
		return weight;
	}

}
