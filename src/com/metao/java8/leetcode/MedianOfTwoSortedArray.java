package com.metao.java8.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        double median = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        findMedianSortedArraysMethod2(new int[]{1, 2}, new int[]{1, 2});
        char s ='c';
        boolean a= s != '\0';
        System.out.println(median);
    }

    private static double findMedianSortedArraysMethod2(int[] num1, int[] num2) {
        int[] answer = new int[num1.length + num2.length];
        int i = num1.length - 1, j = num2.length - 1, k = answer.length;
        while (k > 0)
            answer[--k] = (j < 0 || (i >= 0 && num1[i] >= num2[j])) ? num1[i--] : num2[j--];
        double result;
        if (answer.length % 2 == 0) {
            result = answer[answer.length / 2 - 1];
            result += answer[answer.length / 2];
            result /= 2;
        } else {
            result = answer[answer.length / 2];
        }
        return result;
    }

    public static double findMedianSortedArrays(int[] num1, int[] num2) {
        List<Integer> list = new ArrayList<>();
        int x = 0, y = 0;
        double result;
        while (x < num1.length && y < num2.length) {
            if (num1[x] < num2[y]) {
                list.add(num1[x++]);
            } else {
                list.add(num2[y++]);
            }
        }
        while (x < num1.length) {
            list.add(num1[x++]);
        }
        while (y < num2.length) {
            list.add(num2[y++]);
        }
        System.out.println(list);
        if (list.size() % 2 == 0) {
            result = list.get(list.size() / 2 - 1);
            result += list.get(list.size() / 2);
            result /= 2;
        } else {
            result = list.get(list.size() / 2);
        }
        return result;
    }

}
