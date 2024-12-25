package com.metao.examples.challenges;


public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int key = 2;
        int index = binarySearch(arr, key);
        System.out.println("key: " + key + " found at index:" + index);
    }

    private static int binarySearch(int[] arr, int key) {
        return binarySearchRecursive(arr, 0, arr.length - 1, key);
    }

    private static int binarySearchRecursive(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (start) + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
            return binarySearchRecursive(arr, start, mid - 1, key);
        } else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
            return binarySearchRecursive(arr, mid + 1, end, key);
        } else if (arr[end] <= arr[mid]) {
            return binarySearchRecursive(arr, mid + 1, end, key);
        } else if (arr[start] >= arr[mid]) {
            return binarySearchRecursive(arr, start, mid - 1, key);
        }
        return -1;
    }
}
