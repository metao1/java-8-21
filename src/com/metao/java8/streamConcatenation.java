package com.metao.java8;

import java.util.stream.Stream;

public class streamConcatenation {

    public static void main(String[] args) {

        Stream.concat(Stream.of("hello"), Stream.of(1))
                .forEach(System.out::println);
    }
}
