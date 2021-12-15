package com.metao.java8.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class PreOrderTraversal {
    public static void main(String[] args) {
        final String inputTree = """
                   10
                  / \
                 2   11
                  \\   \\                                   
                   3    12   
                """;

        try (BufferedReader br = new BufferedReader(new StringReader(inputTree))) {
            Node root = null;
            String input;
            while ((input = br.readLine()) != null) {
                if (!input.contains("\\") || !input.contains("//")) {
                    String[] st = input.split("\\s+");
                    for (String s : st) {
                        try {
                            final int data = Integer.parseInt(s);
                            root = createNodeRecursive(root, data);
                        } catch (NumberFormatException ignore) {

                        }
                    }
                }
            }
            printPreOrder(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Node createNodeRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node temp;
            if (data <= root.data) {
                temp = createNodeRecursive(root.left, data);
                root.left = temp;
            } else {
                temp = createNodeRecursive(root.right, data);
                root.right = temp;
            }
            return root;
        }
    }

    private static void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + "\s");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
