package com.metao.java8.hackerrank;

import java.util.*;

public class ShortestPathDijkstra {

    public static void main(String[] args) {
        int n = 5, m = 3;
        List<List<Integer>> list = List.of(List.of(1, 2), List.of(1, 3), List.of(3, 4));
        List<Integer> weights = dijkstra(n, m, list, 1);
        System.out.println(weights);
    }

    public static List<Integer> dijkstra(int n, int m, List<List<Integer>> list, int startIndex) {
        Graph graph = Graph.build(n, list);
        int[] shortestSet = graph.shortestReach(startIndex);
        return graph.buildShortestPath(startIndex, shortestSet);
    }

    private static class Graph {
        private final int nodeCount; // number of nodes in graph
        private final List<List<Edge>> adj; // list of edges for each node.

        private Graph(int vCount) {
            this.nodeCount = vCount;
            this.adj = new LinkedList<>();
            for (int i = 0; i < vCount + 1; i++) {
                this.adj.add(i, new ArrayList<>());
            }
        }

        public static Graph build(int n, List<List<Integer>> list) {
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
            adj.get(from.getIndex()).add(new Edge(from, to, weight));
            adj.get(to.getIndex()).add(new Edge(to, from, weight));
        }

        public List<Integer> buildShortestPath(int startIndex, int[] shortestSet) {
            List<Integer> subs = new ArrayList<>();
            for (int i = 0; i < shortestSet.length; i++) {
                if (i != startIndex) {
                    subs.add(shortestSet[i]);
                }
            }
            return subs.subList(1, subs.size());
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[nodeCount];
            Arrays.fill(distances, -1); // O(n) space.
            Queue<Integer> que = new LinkedList<>();

            que.add(startId); // Initialize queue.
            distances[startId] = 0;
            HashSet<Integer> seen = new HashSet<>(); //O(n) space. Could be further optimized.

            seen.add(startId);
            while(!que.isEmpty()) { // Standard BFS loop.
                Integer curr = que.poll();
                for(Edge edge : adj.get(curr)) {
                    int node = edge.getTo().getIndex();
                    if(!seen.contains(node)) {
                        que.offer(node);
                        // Right place to add the visited set.
                        seen.add(node);
                        // keep on increasing distance level by level.
                        distances[node] = distances[curr] + edge.getWeight();
                    }
                }
            }
            return distances;
        }

        private static class Vertex implements Comparable<Vertex> {
            private final int index;

            Vertex(int index) {
                this.index = index;
            }

            int getIndex() {
                return index;
            }

            @Override
            public int compareTo(Vertex o) {
                return Double.compare(index, o.index);
            }
        }

        private static class Edge implements Comparable<Edge> {

            private final Vertex from;
            private final Vertex to;
            private final int weight;

            Edge(Vertex from, Vertex to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

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
