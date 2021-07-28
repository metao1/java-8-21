package com.metao.java8;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorsExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorsExamples executorsExamples = new ExecutorsExamples();
    }

    ExecutorsExamples() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Queue<CompletableFuture<List>> queue = new ConcurrentLinkedQueue<>();

        List<Integer> collect1 = IntStream.range(0, 10)
                .boxed()
                .map(item -> item * 6)
                .collect(Collectors.toList());

        queue.add(CompletableFuture.supplyAsync(() -> collect1));
        queue.add(CompletableFuture.supplyAsync(() -> collect1.stream().filter(i -> i % 14 == 0).collect(Collectors.toList())));
        Stack<CompletableFuture<List>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            CompletableFuture<List> poll = queue.poll();
            if (!stack.isEmpty()) {
                CompletableFuture<List> pop = stack.pop();
                stack.push(pop.thenCombineAsync(poll, (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }));
            }
            if (stack.isEmpty()) {
                stack.push(poll);
            }
        }
        executorService.shutdown();
        System.out.println(stack.pop().get());
    }
}
