package com.brewo.graph;

public interface Edge<N, E> {

	public N getFromNode();
	public N getToNode();
	public int getWeight();
}
