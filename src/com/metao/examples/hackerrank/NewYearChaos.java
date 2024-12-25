package com.metao.examples.hackerrank;

import java.util.List;

public class NewYearChaos {

    public static void main(String[] args) {
        minimumBribes(List.of(2, 1, 5, 3, 4));
    }

    public static void minimumBribes(List<Integer> q) {
        int p1 = 1, p2 = 2, p3 = 3;
        int bribes = 0;
        for (Integer value : q) {
            if (value == p1) {
                p1 = p2;
                p2 = p3;
                p3++;
            } else if (value == p2) {
                bribes++;
                p2 = p3;
                p3++;
            } else if (value == p3) {
                bribes += 2;
                p3++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribes);
    }
}
