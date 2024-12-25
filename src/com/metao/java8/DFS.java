package com.metao.java8;

import java.util.Stack;

public class DFS {

    static class Vertex {
        private final String cell;

        Vertex(String cell) {
            this.cell = cell;
        }
    }

    static class Tree {
        public final Vertex vertex;
        public final Tree left;
        public final Tree right;
        public boolean visited;

        private Tree(Builder builder) {
            this.left = builder.getLeft();
            this.right = builder.getRight();
            this.vertex = builder.getValue();
        }

        public static class Builder {
            private Tree left, right;
            private final Vertex value;

            public Builder(Vertex vertex) {
                value = vertex;
            }

            public static Builder builder(Vertex vertex) {
                return new Builder(vertex);
            }

            public Builder setLeft(Tree left) {
                this.left = left;
                return this;
            }

            public Builder setRight(Tree right) {
                this.right = right;
                return this;
            }

            public Tree getLeft() {
                return left;
            }

            public Tree getRight() {
                return right;
            }

            public Vertex getValue() {
                return value;
            }

            Tree build() {
                return new Tree(this);
            }
        }

        public Vertex getVertex() {
            return vertex;
        }

        public Tree getRight() {
            return right;
        }

        public Tree getLeft() {
            return left;
        }
    }

    public DFS() {
        Tree tree = Tree.Builder.builder(new Vertex("2"))
                .setLeft(Tree.Builder.builder(new Vertex("3"))
                        .setLeft(Tree.Builder.builder(new Vertex("4")).build())
                        .setRight(Tree.Builder.builder(new Vertex("1")).build())
                        .build()
                )
                .setRight(Tree.Builder.builder(new Vertex("10")).build())
                .build();

        Tree tree2 = Tree.Builder.builder(new Vertex("1"))
                .setLeft(Tree.Builder.builder(new Vertex("2"))
                        .setLeft(Tree.Builder.builder(new Vertex("3"))
                                .setLeft(Tree.Builder.builder(new Vertex("4")).build())
                                .setRight(Tree.Builder.builder(new Vertex("5")).build())
                                .build())
                        .build()).build();

        Stack<Tree> vertices = new Stack<>();
        vertices.push(tree);
        vertices.push(tree2);
        while (!vertices.isEmpty()) {
            Tree topNode = vertices.pop();
            if (!topNode.visited) {
                System.out.println(topNode.vertex.cell);
            }
            topNode.visited = true;
            Tree leftChild = topNode.left;
            Tree rightChild = topNode.right;
            if (rightChild != null && !rightChild.visited) {
                vertices.push(rightChild);
            }
            if (leftChild != null && !leftChild.visited) {
                vertices.push(leftChild);
            }
        }
    }

    public static void main(String[] args) {
        new DFS();
    }
}
