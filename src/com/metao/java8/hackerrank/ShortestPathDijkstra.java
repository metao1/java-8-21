package com.metao.java8.hackerrank;

import java.util.*;

public class ShortestPathDijkstra {

    public static void main(String[] args) {
        int n = 6, m = 2, s = 1;
        final Graph graph = Graph.createGraph(n);
        for (int i = 0; i < n; i++) {
            graph.addVertex(new Vertex(i));
        }
        final List<Vertex> vertices = graph.vertices();
        vertices.get(1).edges = List.of(new Graph.Edge(2, 6), new Graph.Edge(3, 6));

        printShortestPath(n, graph, s);
        //final List<Integer> shortestPath = getShortestPath(n, m, List.of(List.of(1, 2), List.of(2, 3)), 1);
        //System.out.println(shortestPath);
    }

    private static List<Integer> getShortestPath(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> distances = new ArrayList<>(n + 1);
        List<Boolean> seen = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            distances.add(-1);
            seen.add(i, false);
        }
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            Integer currentIndex = queue.poll();
            if (!seen.get(currentIndex)) {
                seen.set(currentIndex, true);
                for (List<Integer> edge : edges) {
                    if (edge.get(0).equals(currentIndex)) {
                        queue.add(edge.get(1));
                    }
                }
                for (Integer dest : queue) {
                    int dist = distances.get(dest), current = distances.get(currentIndex);
                    if (dist == -1) {
                        dist = Integer.MAX_VALUE;
                    }
                    if (current == -1) {
                        current = 0;
                    }
                    if (current + 6 < dist) {
                        distances.set(dest, current + 6);
                    }
                }
            }
        }
        System.out.println(distances);
        distances = distances.subList(s + 1, distances.size());
        for (int i = 0; i < distances.size(); i++) {
            if (distances.get(i) == Integer.MAX_VALUE) {
                distances.set(i, -1);
            }
        }
        return distances;
    }

    private static void printShortestPath(int n, Graph graph, int s) {
        if (n == 0 || graph.isEmpty()) {
            return;
        }
        final List<Vertex> vertices = graph.vertices();
        List<Boolean> seen = new ArrayList<>(n + 1);
        Queue<Vertex> queue = new PriorityQueue<>();
        Vertex rootVertex = vertices.get(s);
        queue.offer(rootVertex);//insert starting node into queue
        for (int i = 0; i < n + 1; i++) {
            seen.add(false);
        }
        rootVertex.cost = 0;
        while (!queue.isEmpty()) {
            Vertex pointedVertex = queue.poll();
            final int pointedIndex = pointedVertex.index;
            if (!seen.get(pointedIndex)) {
                seen.set(pointedIndex, false);
                final List<Graph.Edge> edges = pointedVertex.edges();
                for (Graph.Edge edge : edges) {
                    Vertex neighborVertex = vertices.get(edge.index);
                    neighborVertex.setCost(Math.min(pointedVertex.cost + edge.w, neighborVertex.cost));
                    queue.add(graph.vertices.get(edge.index));
                }
            }
        }
        System.out.println(graph.vertices);
    }

    private static class Graph {
        private static Graph instance = null;
        private List<Vertex> vertices;

        private Graph() {
        }

        public void addVertex(Vertex vertex) {
            if (instance == null) {
                return;
            }
            instance.vertices.add(vertex);
        }

        public List<Vertex> vertices() {
            return instance.vertices;
        }

        public static Graph createGraph(int n) {
            if (instance == null) {
                instance = new Graph();
            }
            instance.vertices = new ArrayList<>(n + 1);
            for (int i = 1; i < n + 1; i++) {
                instance.vertices.add(new Vertex(i));
            }
            return instance;
        }

        public boolean isEmpty() {
            return instance.vertices == null;
        }

        public final static class Edge {
            int index, w;

            Edge(int index, int w) {
                this.index = index;
                this.w = w;
            }
        }
    }

    static final class Vertex implements Comparator<Vertex> {
        int index;
        List<Graph.Edge> edges = new ArrayList<>();
        int cost = Integer.MAX_VALUE;

        Vertex(int index) {
            this.index = index;
        }

        public void addEdge(Graph.Edge edge) {
            this.edges.add(edge);
        }

        private void setCost(int cost) {
            this.cost = cost;
        }

        int getCost() {
            return cost;
        }

        List<Graph.Edge> edges() {
            return edges;
        }

        @Override
        public int compare(Vertex v1, Vertex v2) {
            if (v1.cost < v2.cost)
                return -1;
            else if (v1.cost > v2.cost)
                return 1;
            return 0;
        }
    }

}
