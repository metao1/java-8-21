package com.metao.java8;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CompletableFutureThread {

    CompletableFutureThread() throws InterruptedException, ExecutionException {
        List<Integer> commands = List.of(10, 20, 10, 400, 23, 5000);
        List<CompletableFuture<Integer>> collect = commands.stream()
                .map(action -> CompletableFuture.supplyAsync(supplier(action)))
                .collect(Collectors.toList());

        Thread.sleep(1000);
        List<Boolean> collect1 = collect.stream()
                .filter(future-> !future.isDone())
                .map(future-> future.cancel(true))
                .collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("finished");

    }

    private Supplier<Integer> supplier(Integer waitTime) {
        return ()-> {
            try {
                TimeUnit.MILLISECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return waitTime;
        };
    }

    private Callable<Integer> callable(Integer waitTime) {
        return () -> {
            try {
                //process shit here
                TimeUnit.MILLISECONDS.sleep(waitTime);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return waitTime;
        };
    }


    private static Runnable runnable(int waitTime) {
        return () -> {
            try {
                //process shit here
                TimeUnit.MILLISECONDS.sleep(waitTime);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new CompletableFutureThread();
    }
}
