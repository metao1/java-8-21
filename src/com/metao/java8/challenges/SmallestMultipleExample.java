package com.metao.java8.challenges;

import java.util.stream.IntStream;


public class SmallestMultipleExample {

    public static void main(String[] args) {
        int foundValue = 0;
        for (int i = 1000; i < 2000000; i++) {
            int finalI = i;
            boolean b = IntStream.range(1, 19)
                    .boxed()
                    .map(num -> (finalI % num))
                    .filter(outcome -> outcome == 0)
                    .count() == 18;
            if (b) {
                foundValue = finalI;
                break;
            }
        }
        System.out.println(foundValue);
    }
}
