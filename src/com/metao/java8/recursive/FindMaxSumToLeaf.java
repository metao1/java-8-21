package com.metao.java8.recursive;

public class FindMaxSumToLeaf {

    public static void main(String[] args) {
        /*
         *               1
         *             2   3
         *              4 5 6
         *               7
         */
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);
        var node6 = new Node(6);
        var node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.right = node7;

        int value = findMaxDataFromRootToLeaf(node1);
        System.out.println(value);
    }

    private static int findMaxDataFromRootToLeaf(Node root) {
        if (root == null) {
            return 0;
        }
        int data = root.data;
        int left = findMaxDataFromRootToLeaf(root.left);

        int right = findMaxDataFromRootToLeaf(root.right);

        return Math.max(left, right) + data;
    }

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
