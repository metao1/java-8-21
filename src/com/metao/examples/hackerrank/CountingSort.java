package com.metao.examples.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class CountingSort {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5,5);
        int[] result = new int[10];
        for (Integer integer : list) {
            result[integer] = result[integer] + 1;
        }
        Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
