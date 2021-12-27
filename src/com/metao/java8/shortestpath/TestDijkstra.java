package com.metao.java8.shortestpath;

public class TestDijkstra {

    public static void main(String[] args) {
        var graph = new WeightedAdjacencyListGraph(4, true);
        graph.addEdge(new Vertex("1"), new Vertex("2"), 6);
        graph.addEdge(new Vertex("1"), new Vertex("3"), 6);
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.computeShortestPaths(new Vertex("1"));
    }
}
