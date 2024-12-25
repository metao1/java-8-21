package com.metao.examples.sort;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public static void main(String[] args) {
        List<Integer> list = List.of(7, 6, 5, 4, 3, 2, 1, Integer.MAX_VALUE);
        Integer[] array = list.toArray(Integer[]::new);
        quickSort(array, 0, list.size() - 1);
        System.out.println(Arrays.toString(array));
        boolean sorted = testIfSorted(array);
        System.out.println(count);
        assert sorted;
    }

    private static boolean testIfSorted(Integer[] sortedList) {
        return false;
    }
    static int count=0;
    private static void quickSort(Integer[] arr, int l, int h) {
        int pivot = findPivot(arr, l, h);
        if (l < h) {
            quickSort(arr, l, pivot);
            quickSort(arr, pivot + 1, h);
        }
    }

    private static int findPivot(Integer[] arr, int l, int h) {
        int i = l, j = h;
        int pivot = arr[l];
        while (i < j) {
            do {
                i++;
                count++;
            } while (arr[i] <= pivot && i < h);
            do {
                j--;
                count++;
            } while (arr[j] > pivot);
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
