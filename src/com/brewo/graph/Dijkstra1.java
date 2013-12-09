package com.brewo.graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra1<N, E> {

    private PriorityQueue<DijkstraNode<N>> unvisited;
    private Map<N, DijkstraNode<N>> all;
    private final Graph<N, E> graph;
    private DijkstraNode<N> current;
    private N to;

    public Dijkstra1(Graph<N, E> g, N from, N to) {
        graph = g;
        this.to = to;
        Set<DijkstraNode<N>> dijkstraNodes = new HashSet<>();
        all = new HashMap<>();
        for (N n : g.getNodes()) {
            if (n.equals(from)) {
                DijkstraNode<N> dijkstraNode = new DijkstraNode(n, 0);
                dijkstraNodes.add(dijkstraNode);
                all.put(n, dijkstraNode);
                current = dijkstraNode;
            } else {
                DijkstraNode<N> dijkstraNode = new DijkstraNode(n, Integer.MAX_VALUE);
                dijkstraNodes.add(dijkstraNode);
                all.put(n, dijkstraNode);
            }
        }
        unvisited = new PriorityQueue<>(dijkstraNodes);
    }

    public int run() {
        DijkstraNode<N> dn = all.get(to);
        while (unvisited.contains(dn)) {
            calculateNeighbours();
            current = unvisited.peek();
        }
        for (DijkstraNode<N> dn2 : all.values()) {
            System.out.println(dn2.getN() + ": " + dn2.dist);
        }
        return all.get(to).getDist();
    }

    private void calculateNeighbours() {
        List<N> nexts = graph.getAdjoiningNodes(current.getN());
        for (N next : nexts) {
        	
            DijkstraNode<N> dn = all.get(next.getNode());
            if (unvisited.contains(dn)) {
                int newDist = current.getDist() + next.getEdge().getWeight();
                if (newDist < dn.getDist()) {
                    unvisited.remove(dn);
                    dn.setDist(newDist);
                    unvisited.add(dn);
                }
            }
        }
        unvisited.remove(current);
    }

    private class DijkstraNode<N> implements Comparable<DijkstraNode<N>> {

        private final N n;
        private int dist;

        private DijkstraNode(N n, int dist) {
            this.n = n;
            this.dist = dist;
        }

        private N getN() {
            return n;
        }

        private int getDist() {
            return dist;
        }

        private void setDist(int dist) {
            this.dist = dist;
        }

        @Override
        public int compareTo(DijkstraNode<N> o) {
            return Integer.compare(this.dist, o.getDist());
        }

    }

}
