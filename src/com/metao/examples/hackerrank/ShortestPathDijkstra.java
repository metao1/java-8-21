package com.metao.examples.hackerrank;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;

public class ShortestPathDijkstra {

    public static void main(String[] args) {
        int n = 5, m = 3;
        List<List<Integer>> list = List.of(List.of(1, 2), List.of(1, 3), List.of(3, 4));
        List<Integer> weights = dijkstra(n, m, list, 1);
        System.out.println(weights);
    }

    public static List<Integer> dijkstra(int nodeCount, int m, List<List<Integer>> indexList, int startIndex) {
        Graph graph = Graph.buildFromIndexList(nodeCount, indexList);
        int[] distances = new int[nodeCount];
        HashSet<Integer> seen = new HashSet<>(); //O(n) space. Could be further optimized.
        Queue<Integer> q = new LinkedList<>();
        setupDijkstra(startIndex, distances, q);
        while (!q.isEmpty()) { // Standard BFS loop.
            Integer from = q.poll();
            updateNeighbors(graph, q, seen, distances, from);
        }
        return buildShortestPath(startIndex, distances);
    }

    private static void setupDijkstra(int startIndex, int[] distances, Queue<Integer> q) {
        Arrays.fill(distances, -1); // O(n) space.
        q.add(startIndex); // Initialize queue.
        distances[startIndex] = 0;
    }

    private static void updateNeighbors(Graph g, Queue<Integer> q, HashSet<Integer> seen, int[] distances, Integer from) {
        List<Graph.Edge> neighbors = g.getNeighbors(from);
        for (Graph.Edge neighbor : neighbors) {
            int to = neighbor.getTo().getIndex();
            if (!seen.contains(to)) {
                q.offer(to);
                seen.add(to); // Right place to add the visited set.
                // keep on increasing distance level by level.
                distances[to] = distances[from] + neighbor.getWeight();
            }
        }
    }

    private static List<Integer> buildShortestPath(int startIndex, int[] shortestSet) {
        List<Integer> subs = new ArrayList<>();
        for (int i = 0; i < shortestSet.length; i++) {
            if (i != startIndex) { // everything except the startIndex
                subs.add(shortestSet[i]);
            }
        }
        return subs.subList(1, subs.size()); // since startIndex starts from one, ignoring index zero
    }

    private static class Graph {
        private final List<List<Edge>> adj; // list of edges for each node.

        private Graph(int vCount) {
            this.adj = new LinkedList<>();
            for (int i = 0; i < vCount + 1; i++) {
                this.adj.add(i, new ArrayList<>());
            }
        }

        public List<Edge> getNeighbors(int index) {
            return adj.get(index);
        }

        public static Graph buildFromIndexList(int n, List<List<Integer>> list) {
            Graph graph = new Graph(n);
            for (List<Integer> edgeList : list) {
                if (edgeList == null || edgeList.isEmpty()) {
                    continue;
                }
                Integer from = edgeList.get(0);
                Integer to = edgeList.get(1);
                graph.addEdge(new Vertex(from), new Vertex(to), 6);
            }
            return graph;
        }

        public void addEdge(Vertex from, Vertex to, int weight) {
            adj.get(from.getIndex()).add(new Edge(from, to, weight)); // from <-> to, creating a bidirectional edge
            adj.get(to.getIndex()).add(new Edge(to, from, weight));// to <-> from
        }

        private record Vertex(int index) implements Comparable<Vertex> {

            int getIndex() {
                return index;
            }

            @Override
            public int compareTo(Vertex o) {
                return Double.compare(index, o.index);
            }
        }

        private record Edge(Vertex from, Vertex to, int weight) implements Comparable<Edge> {

            Vertex getTo() {
                return to;
            }

            int getWeight() {
                return weight;
            }

            @Override
            public int compareTo(Edge o) {
                return Integer.compare(o.weight, weight);
            }
        }
    }
}
