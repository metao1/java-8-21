package com.metao.examples;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        // Java 8
        String[] result = Stream.of(array)  // Stream<String[]>
                .flatMap(Stream::of)        // Stream<String>
                .toArray(String[]::new);    // [a, b, c, d, e, f]

        for (String s : result) {
            System.out.println(s);
        }
        Map<Integer, List<String>> mapFrom = new HashMap<>();
        mapFrom.put(1, List.of("1", "2", "3"));
        Map<String, Integer> mapTo = mapFrom.entrySet().stream()
                .flatMap(e -> e.getValue().stream()
                        .map(v -> new AbstractMap.SimpleImmutableEntry<>(e.getKey(), v)))
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        System.out.println(mapTo);
    }
}
