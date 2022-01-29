package com.metao.java8.hackerrank;

import java.util.List;

public class MinTankIndex {
    public static void main(String[] args) {
        List<List<Integer>> petrolLists = List.of(List.of(10, 7), List.of(1, 5), List.of(6, 5));
        int minIndex = minIndex(petrolLists);
        System.out.println(minIndex);
    }

    private static int minIndex(List<List<Integer>> petrolLists) {
        int size = petrolLists.size();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            List<Integer> instruction = petrolLists.get(i);
            Integer petrol = instruction.get(0);
            Integer distance = instruction.get(1);
            int remaining = petrol - distance;
            if (remaining < 0) {
                continue;
            }
            int j;
            for (j = i + 1; j < size + i; j++) {
                instruction = petrolLists.get(j % size);
                petrol = instruction.get(0);
                distance = instruction.get(1);
                remaining = (petrol + remaining) - distance;
                if (remaining < 0) {
                    break;
                }
            }
            if (j < size + i)
                minIndex = Math.min(i, minIndex);
        }
        return minIndex;
    }
}
