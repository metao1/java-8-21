package com.metao.examples.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.lang.System.out;

public class JessAndCookies {

    public static void main(String[] args) {
        //final int result = cookies(105823341, new ArrayList<>(IntStream.range(0, 100000).boxed().map(i -> 1).collect(Collectors.toList())));
        final int result = cookies(6, new ArrayList<>(List.of(1, 2, 3, 9, 10, 12)));
        out.println(result);
    }


    public static int cookies(int k, List<Integer> a) {
        // Write your code here
        Integer second = 0, first = 0, sum = 0, counter = 0;
        Queue<Integer> queue = new PriorityQueue<>(a);
        while (!queue.isEmpty() && queue.peek() <= k) {
            first = queue.poll();
            second = queue.poll();
            sum = 0;
            if (first != null && second != null) {
                sum = first + (second * 2);
                queue.add(sum);
                counter++;
            }
        }
        out.println(queue.isEmpty());
        if (first < k && queue.isEmpty()) {
            return -1;
        }
        if (counter >= 0)
            return counter;
        else
            return -1;
    }

}
