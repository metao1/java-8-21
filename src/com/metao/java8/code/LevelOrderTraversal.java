package com.metao.java8.code;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) throws InterruptedException {
        BinaryTreeNode node1 = new BinaryTreeNode(100);
        BinaryTreeNode node2 = new BinaryTreeNode(50);
        BinaryTreeNode node3 = new BinaryTreeNode(200);
        node1.left = node2;
        node1.right = node3;
        BinaryTreeNode node4 = new BinaryTreeNode(25);
        BinaryTreeNode node5 = new BinaryTreeNode(75);
        node2.left = node4;
        node2.right = node5;
        BinaryTreeNode node6 = new BinaryTreeNode(350);
        node3.right = node6;
        String levelOrderTraversal = levelOrderTraversal(node1);
        System.out.println(levelOrderTraversal);
        String inorderTraversal = inorderTraversal(node1);
        System.out.println(inorderTraversal);
    }

    private static String inorderTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        BinaryTreeNode node;
        while ((node = queue.poll()) != null) {
            sb.append(node.data).append(",");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sb.toString();
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
        for (int i = 0; i < queue.size(); i++) {
            BinaryTreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.data).append("\t");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.append("\n");
    }

    private static class BinaryTreeNode {
        int data;
        BinaryTreeNode right;
        BinaryTreeNode left;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }
}
