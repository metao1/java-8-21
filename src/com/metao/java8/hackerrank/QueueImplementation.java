package com.metao.java8.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QueueImplementation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queryNum;
        try {
            queryNum = Integer.parseInt(br.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<List<Integer>> inputs = IntStream.range(0, queryNum)
                .mapToObj(it -> {
                    try {
                        return Stream.of(br.readLine().trim().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }).toList();
        final Queue queue = new Queue();
        for (List<Integer> input : inputs) {
            invokeAction(input, queue);
        }
    }

    private static void invokeAction(List<Integer> input, Queue queue) {
        if (input == null || input.isEmpty()) {
            return;
        }
        int action = input.get(0);
        int data = 0;
        if (input.size() == 2) {
            data = input.get(1);
        }
        switch (action) {
            case 3 -> System.out.println(queue.element().data);
            case 2 -> queue.dequeue();
            case 1 -> queue.enqueue(data);
        }
    }

    private static class Queue {

        transient Node start;
        transient Node end;

        void enqueue(int data) {
            Node e = new Node(data);
            Node l = end;
            end = e;
            if (start == null) {
                start = e;
            } else {
                l.next = e;
            }
        }

        Node element() {
            return start;
        }

        Node dequeue() {
            Node nodeToReturn = start;
            start = start.next;
            nodeToReturn.next = null;
            return nodeToReturn;
        }

        private static class Node {
            Node next;
            int data;

            Node(int data) {
                this.data = data;
            }

            Node next() {
                return next;
            }
        }
    }
}

