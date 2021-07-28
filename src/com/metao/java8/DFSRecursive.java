package com.metao.java8;

import java.util.*;

public class DFSRecursive {

    void DFS() {
        Stack<Integer> numbers = new Stack<>();
        Graphz<Integer> graphz = new Graphz<>(new HashMap<>());
    }

    class Vertex<V> {

    }

    interface Graph<V> {
        Map<V, List<V>> map();

        void addVertex(V v);

        void addEdge(V v1, V v2);
    }

    static class Graphz<V> implements Graph<V> {

        private Map<V, List<V>> map;

        Graphz(Map<V, List<V>> map) {
            this.map = map;
        }

        @Override
        public Map<V, List<V>> map() {
            return this.map;
        }

        @Override
        public void addVertex(V v) {
            this.map.putIfAbsent(v, new ArrayList<>());
        }

        @Override
        public void addEdge(V v1, V v2) {
            //this.map.computeIfAbsent();
        }

    }

    public static void main(String[] args) {
        new DFSRecursive();
    }
}
