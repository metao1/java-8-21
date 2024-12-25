package com.metao.examples.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SortingInJavaExample {

    public static void main(String[] args) {
        List<Integer> unsortedList = List.of(2, 3, 4, 1, 5, 10, 7, 6, 8, 9);
        method1(unsortedList);
        method2(unsortedList);
        method3(unsortedList);
        method4(unsortedList);
    }

    private static void method1(List<Integer> unsortedList) {
        System.out.println("method1");
        long now = System.nanoTime();
        List<Integer> sortedList = new ArrayList<>(unsortedList);
        Collections.sort(sortedList);
        System.out.println("Took " + (System.nanoTime() - now) + "ns");
        System.out.println(sortedList);
    }

    private static void method2(List<Integer> unsortedList) {
        System.out.println("method2");
        long now = System.nanoTime();
        SortedSet<Integer> sortedSet = new TreeSet<>(unsortedList);
        System.out.println("Took " + (System.nanoTime() - now) + "ns");
        System.out.println(sortedSet);
    }

    private static void method3(List<Integer> unsortedList) {
        System.out.println("method3");
        long now = System.nanoTime();
        List<Integer> sortedObjects = unsortedList.stream().sorted().collect(Collectors.toList());
        System.out.println("Took " + (System.nanoTime() - now) + "ns");
        System.out.println(sortedObjects);
    }

    private static void method4(List<Integer> unsortedList) {
        System.out.println("method4");
        long now = System.nanoTime();
        Integer[] integers = unsortedList.toArray(new Integer[0]);
        Arrays.sort(integers);
        String formattedOutput = Arrays.stream(integers)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Took " + (System.nanoTime() - now) + "ns");
        System.out.println(formattedOutput);
    }
}
