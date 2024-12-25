package com.metao.java8.bad_practice_codes_refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelModification {
    public static void main(String[] args) throws InterruptedException {
        new ParallelModification().badParallelUsage();
    }

    private void badParallelUsage() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, 20000)
                .parallel()
                .boxed()
                .toList();
        System.out.println(list.size());
    }
}
