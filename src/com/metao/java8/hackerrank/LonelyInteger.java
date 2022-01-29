package com.metao.java8.hackerrank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LonelyInteger {

    public static void main(String[] args) {
        Integer lonelyInt = Stream.of(1, 2, 1, 2, 2, 1, 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.mapping(i -> i, Collectors.toList())))
                .values()
                .stream()
                .filter(i -> i.size() == 1)
                .findFirst()
                .orElse(List.of())
                .get(0);
        System.out.println(lonelyInt);
    }
}
