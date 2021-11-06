package com.metao.java8.hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindSumOfSubarray {

    public static void main(String[] args) {
        int diff = sumSubarrayMins(new int[]{4, 4, 4, 41});
        System.out.println(diff);
    }
    public static int sumSubarrayMins(int[] arr) {
        List<int[]> subArrList = new LinkedList<>();
        List<Integer> minList = new LinkedList<>(), maxList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++) {
                if (i <= j) {
                    int[] subArray = Arrays.copyOfRange(arr, i, j + 1);
                    subArrList.add(subArray);
                }
            }
        for (int[] items : subArrList) {
            int min = Arrays.stream(items).min().getAsInt();
            int max = Arrays.stream(items).max().getAsInt();
            minList.add(min);
            maxList.add(max);
        }
        return maxList.stream().reduce(Integer::sum).get() - minList.stream().reduce(Integer::sum).get() ;
    }
}
