package com.brewo.graph;

import java.util.List;


//dikstra

//Stworzyć interfejs Graf o następujących metodach
//    Dodaj węzeł
//    Usuń węzeł
//    Dodaj krawędź
//    Usuń krawędź
//    Podaj węzły sąsiednie do węzła
//    Podaj krawędzie incydentne do węzła
//    Znajdź węzeł
//    Znajdź krawędź
//    Podaj końce krawędzi
//    Podaj ilość węzłów
//    Podaj ilość krawędzi
//    Czy węzły są sąsiednie
//Zaimplementować powyższy interfejs za pomocą reprezentacji:
//    macierzowej
//    listy sąsiedztw

//algorytm grafowy bedzzie treba napisac
public interface Graph<N, E> {

	public void addNode(N n);
	
	public void deleteNode(N n);
	
	public void addEdge(E e, N n1, N n2);
	
	public void addEdge(E e, N n1, N n2, int weight);
	
	public void deleteEdge(E e);
	
	public List<N> getAdjoiningNodes(N n);
	
	public List<E> getAdjoiningEdges(N n);
	
	public boolean containsNode(N n); //
	
	public boolean containsEdge(E e);
	
	public Edge<N,E> getEdgeEnds(E e);
	
	public int getNodesCount();
	
	public int getEdgesCount();
	
	public boolean areNeighbours(N n1, N n2);
	
	//help methods
	public int countNodes();
	public int countEdges();
	
	public List<N> getNodes();
	
	public int getDistance(N n1, N n2);
	
	
}
