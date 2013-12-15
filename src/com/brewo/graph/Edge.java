package com.brewo.graph;

public interface Edge<N, E> {

	public N getFromNode();
	public N getToNode();
	public double getWeight();
	public E getInsideObject();
}
