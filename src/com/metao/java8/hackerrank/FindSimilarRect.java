package com.metao.java8.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FindSimilarRect {
    private static long ns;

    public static void main(String[] args) {
        List<List<Long>> sides = List.of(List.of(4L, 8L), List.of(15L, 30L));
        Map<Float, AtomicInteger> freqMap = new HashMap<>();
        for (List<Long> side : sides) {
            float div1 = ((float) side.get(0) / (float) side.get(1));
            freqMap.putIfAbsent(div1, new AtomicInteger(0));
            freqMap.computeIfPresent(div1, (k, v) -> {
                v.getAndIncrement();
                return v;
            });
        }

        for (Map.Entry<Float, AtomicInteger> entry : freqMap.entrySet()) {
            if (entry.getValue().get() != 1) {
                int value = entry.getValue().get();
                ns += factorial(value) / (factorial(value - 2) * 2);
            }
        }

        System.out.println(ns);
    }

    static long factorial(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}
