package com.metao.examples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapClasses {

    public static void main(String[] args) {
        List<String> list = new Random().ints(0, 1000)
                .mapToObj(String::valueOf)
                .limit(100)
                .collect(Collectors.toList());
        List<String> orders = List.of("10", "2", "20", "26");

        Map<String, String> map = new HashMap<>();

        for (String s : orders) {
            map.put(s, s);
        }
        Map<Long, List<String>> collect = list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(collect);
    }
}
