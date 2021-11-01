package com.metao.java8.code;

import java.util.Stack;

public class IsBST {

    public static void main(String[] args) {
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
        BinaryTreeNode node7 = new BinaryTreeNode(90);
        node3.left = node7;
         System.out.println(isBstMethod1(node1));
        System.out.println(isBstMethod2(node1));
    }

    private static boolean isBstMethod2(BinaryTreeNode root) {
        if (root == null)
            return false;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node != null) {
                stack.push(node.left);
                stack.push(node.right);
                if (node.left != null && node.data < node.left.data) {
                    return false;
                }
                if (node.right != null && node.data > node.right.data) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isBstMethod1(final BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right != null && root.data > root.right.data) {
            return false;
        }
        if (root.left != null && root.data < root.left.data) {
            return false;
        }

        return isBstMethod1(root.left) && isBstMethod1(root.right);

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
