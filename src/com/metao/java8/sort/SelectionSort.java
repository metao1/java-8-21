package com.metao.java8.sort;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 10, 1, 2, 5, 6, 7);
        Integer[] array = list.toArray(Integer[]::new);
        selectionSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(count);
    }

    static int count = 0;

    private static void selectionSort(Integer[] array) {
        int i = 0, j = array.length - 1;
        while (j > 0) {
            while (i < j) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
                i++;
                count++;
            }
            j--;
            i = 0;
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
