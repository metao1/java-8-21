package com.metao.examples.challenges;

import java.util.Stack;

public class IsBST {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        node1.left = node2;
        System.out.println(isBstMethod1(node1));
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


    public static boolean isBstMethod1(BinaryTreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBST(BinaryTreeNode root, long leftVal, long rightVal) {
        if(root == null) return true;
        if(root.data >= rightVal || root.data <= leftVal) return false;
        return isBST(root.left, leftVal, root.data) && isBST(root.right, root.data, rightVal);
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
