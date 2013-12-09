package com.brewo.graph;

public class MyEdge<N, E> implements Edge<N, E>{
	
	E insideObject;
	N fromNode;
	N toNode;
	int weight;
	
	public MyEdge(E insideObject, N fromNode, N toNode) {
		this(insideObject, fromNode, toNode, 1);
	}
	
	public MyEdge(E insideObject, N fromNode, N toNode, int weigth) {
		this.insideObject = insideObject;
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

	@Override
	public E getInsideObject() {
		return insideObject;
	}
}
