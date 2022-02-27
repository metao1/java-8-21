package com.metao.java8.hackerrank;

import java.util.Arrays;

public class SumToZero {

    public static void main(String[] args) {
        var arr= sumZero(2);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        //We need two counters one for array index other to actually populate elements in it

        for (int i = 0, j = -n / 2; i < n; i++, j++) {
            //if n is even and j reached 0, we need to skip 0
            if (j == 0 && n % 2 == 0)
                j++;
            arr[i] = j;
        }
        return arr;
    }
}
