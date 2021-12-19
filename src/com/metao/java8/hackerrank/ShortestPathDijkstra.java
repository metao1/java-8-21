package com.metao.java8.hackerrank;

import java.util.*;

public class ShortestPathDijkstra {

    public static void main(String[] args) {
        int n = 6, m = 2, s = 1;
        List<Graph.Node> graph = Graph.createGraph(n, m);
        printShortestPath(n, m, graph, s);
    }

    private static void printShortestPath(int n, int m, List<Graph.Node> graph, int s) {
        if (graph.isEmpty()) {
            return;
        }
        ArrayList<Boolean> seen = new ArrayList<>(n);
        List<Integer> distance = new ArrayList<>(n);
        List<Integer> parents = new ArrayList<>(n);
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(s);//insert starting node into queue
        for (int i = 0; i < n + 1; i++) {
            seen.add(false);
            parents.add(-1);
            distance.add(Integer.MAX_VALUE);
        }
        distance.set(s, 0);
        while (!queue.isEmpty()) {
            int startIndex = queue.poll();
            final Graph.Node node = graph.get(startIndex);
            for (Graph.Vertex vertex : node.vertices) {
                queue.add(vertex.v);
            }
            if (!seen.get(node.index)) {
                seen.add(node.index, true);
                for (Graph.Vertex vertex : node.vertices) {
                    distance.set(vertex.v, Math.min(distance.get(node.index) + vertex.w, distance.get(vertex.v)));
                }
            }
        }
        distance = distance.subList(2, distance.size());
        System.out.println(distance);
    }

    private static class Graph {
        private static List<Node> createGraph(int n, int m) {
            List<Node> graph = new ArrayList<>(n + 1);
            for (int i = 0; i < n + 1; i++) {
                graph.add(new Node(i));
            }
            addEdge(graph, 1, 2, 2);
            addEdge(graph, 1, 3, 4);
            addEdge(graph, 2, 3, 1);
            addEdge(graph, 2, 4, 7);
            addEdge(graph, 3, 5, 3);
            addEdge(graph, 4, 6, 1);
            addEdge(graph, 5, 4, 2);
            addEdge(graph, 5, 6, 5);
            return graph;
        }

        private static void addEdge(List<Node> graph, int u, int v, int w) {
            graph.get(u).vertices.add(new Vertex(v, w));
        }

        final static class Node {
            int index;
            List<Vertex> vertices = new ArrayList<>();

            Node(int index) {
                this.index = index;
            }
        }

        final static class Vertex {
            int w, v;

            Vertex(int v, int w) {
                this.v = v;
                this.w = w;
            }
        }

    }
}
