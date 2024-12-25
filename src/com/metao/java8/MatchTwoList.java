package com.metao.java8;

import java.util.List;
import java.util.stream.Collectors;

public class MatchTwoList {

    public static void main(String[] args) {
        List<String> a = List.of("1", "3", "2");
        List<String> b = List.of("1", "2", "3", "4", "5");
        List<String> stringStream = b.stream().filter(s -> a.stream().anyMatch(s::equals)).collect(Collectors.toList());
        System.out.println(stringStream);
        boolean b1 = b.stream().anyMatch(s -> b.stream().noneMatch(s::equals));
        System.out.println(b1);


    }

    private static List<String> getlist() {
        return null;
    }
}
