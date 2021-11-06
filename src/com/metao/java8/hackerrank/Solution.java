package com.metao.java8.hackerrank;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int i = sumSubarrayMins(new int[]{4, 4, 4, 4, 4});
        System.out.println(i);
    }
    private static class Pair{
        int val;
        int count;
        public Pair(int val, int count){
            this.val = val;
            this.count = count;
        }
    }
    public static int sumSubarrayMins(int[] A) {
        final int n = A.length;
        final int kMod = (int) 1e9 + 7;

        int ans = 0;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Arrays.fill(prev, -1);
        Arrays.fill(next, n);

        for (int i = 0; i < A.length; ++i) {
            while (!stack1.isEmpty() && A[stack1.peek()] > A[i])
                stack1.pop();
            prev[i] = stack1.isEmpty() ? -1 : stack1.peek();
            stack1.add(i);

            while (!stack2.isEmpty() && A[stack2.peek()] > A[i]) {
                int index = stack2.pop();
                next[index] = i;
            }
            stack2.add(i);
        }

        for (int i = 0; i < A.length; ++i)
            ans = (ans + A[i] * (i - prev[i]) * (next[i] - i)) % kMod;

        return ans;
    }
}