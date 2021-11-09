package com.metao.java8.hackerrank;

public class DiagonalDifference {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 2, 3, 4, 5},
                {1, 5, 3, 4, 5},
                {1, 2, 5, 4, 5},
                {1, 2, 3, 5, 5},
                {1, 2, 3, 4, 5}};

        for (int i = 0; i < arr.length; i += 1) {
            System.out.print(arr[i][arr.length - i -1 ]);
        }
    }
}
