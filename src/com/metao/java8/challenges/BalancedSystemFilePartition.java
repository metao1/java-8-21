package com.metao.java8.challenges;

import java.util.List;

public class BalancedSystemFilePartition {

    public static void main(String[] args) {
        int partition = mostBalancedPartition(List.of(-1, 0, 0, 1, 1, 2), List.of(1, 2, 2, 1, 1, 1));
        System.out.println(partition);
    }

    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        // Write your code here
        int[] total = new int[parent.size()];
        for (int i = 0; i < parent.size(); i++) {
            int curr = i;
            while (curr != -1) {
                total[curr] += files_size.get(i);
                curr = parent.get(curr);
            }
        }
        int val = Math.abs(total[0] - 2 * total[1]);
        for (int i = 2; i < total.length; i++) {
            int temp = Math.abs(total[0] - 2 * total[i]);
            if (val > temp) {
                val = temp;
            }
        }
        return val;
    }
}
