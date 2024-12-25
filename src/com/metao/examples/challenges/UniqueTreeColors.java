package com.metao.examples.challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class UniqueTreeColors {

    public static void main(String[] args) {
        String[] colors = new String[]{"red", "blue", "green"};
        BinaryTreeNode root = new BinaryTreeNode("red");
        root.left = new BinaryTreeNode("");
        root.right = new BinaryTreeNode("");
        root.right.left = new BinaryTreeNode("");
        root.right.right = new BinaryTreeNode("");
        root.right.left.right = new BinaryTreeNode("");
        root.right.left.left = new BinaryTreeNode("");
        root.left.left = new BinaryTreeNode("");
        root.left.right = new BinaryTreeNode("");
        root.left.left.left = new BinaryTreeNode("");
        root.left.left.right = new BinaryTreeNode("");
        root.left.right.left = new BinaryTreeNode("");
        root.left.right.right = new BinaryTreeNode("");
        BinaryTreeNode tree = colorTree(colors, root);
        String s = levelOrderTraversal(tree);
        System.out.println(s);
    }

    private static BinaryTreeNode colorTree(String[] colors, BinaryTreeNode root) {
        Queue<String> map = new LinkedList<>();
        return colorRecursive(Arrays.asList(colors), root, map);
    }

    public static String levelOrderTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            handleLevelPrinting(stringBuilder, queue);
        }
        return stringBuilder.toString();
    }

    private static void handleLevelPrinting(StringBuilder sb, Queue<BinaryTreeNode> queue) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            BinaryTreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.color).append("\t");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.append("\n");
    }

    private static BinaryTreeNode colorRecursive(List<String> colors, BinaryTreeNode root, Queue<String> map) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> queue = new Stack<>();
        queue.push(root);
        BinaryTreeNode node;
        while (!queue.isEmpty() && (node = queue.pop()) != null) {
            if (node.parent == null) {
                node.color = colors.get(0);
            } else {
                Collections.shuffle(colors);
                for (String color : colors) {
                    if (!color.equals(node.parent.color)) {
                        node.color = color;
                        break;
                    }
                }
            }
            if (node.left != null) {
                node.left.parent = node;
                queue.push(node.left);
            }
            if (node.right != null) {
                node.right.parent = node;
                queue.push(node.right);
            }
        }
        return root;
    }

    private static class BinaryTreeNode {
        String color;
        BinaryTreeNode parent;
        BinaryTreeNode right;
        BinaryTreeNode left;

        public BinaryTreeNode(String color) {
            this.color = color;
        }
    }
}
