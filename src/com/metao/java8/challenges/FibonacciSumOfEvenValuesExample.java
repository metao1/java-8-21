package com.metao.java8.challenges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FibonacciSumOfEvenValuesExample {


    public FibonacciSumOfEvenValuesExample() {

        List<Long> fiboSequence = new LinkedList<>(Arrays.stream(new Long[]{1L, 2L}).toList());
        long first = 1, second = 2;

        for (int i = 0; i < 4; i++) {
            long temp = second;
            second = first + second;
            first = temp;
            fiboSequence.add(second);
        }

        long sum = 0;
        System.out.println(fiboSequence.stream()
                .filter(i -> i % 2 == 0)
                .reduce((Long::sum))
                .get());

    }

    public static void main(String[] args) {
        new FibonacciSumOfEvenValuesExample();
    }
}
