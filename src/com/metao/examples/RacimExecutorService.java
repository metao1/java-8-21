package com.metao.examples;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacimExecutorService {

    private final static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        new RacimExecutorService(executorService);
    }

    public RacimExecutorService(ExecutorService executorService) throws ExecutionException, InterruptedException, TimeoutException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<Object> execute = execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return IntStream.range(0, 10).boxed().collect(Collectors.toMap(Function.identity(), Function.identity()));
                },
                () -> {
                    System.out.println(Thread.currentThread().getName());
                    return IntStream.range(15, 30).boxed().collect(Collectors.toMap(Function.identity(), Function.identity()));
                });
        Map<String, String> stringStringMap = (Map<String, String>) execute.get(10, TimeUnit.SECONDS);

        System.out.println(stringStringMap);

        System.out.println(System.currentTimeMillis() - startTime);

        executorService.shutdown();
    }


    public synchronized <T> CompletableFuture<Object> execute(Supplier<T> methodSupplier) {
        return createCompletableFuture(methodSupplier);
    }

    public final synchronized <T> CompletableFuture<Object> execute(Supplier<T> ... methodSuppliers) {
        Queue<CompletableFuture<Object>> jobQueue = new LinkedList<>();
        Stack<CompletableFuture<Object>> stack = new Stack<>();
        for (Supplier<T> methodSupplier : methodSuppliers) {
            T item = methodSupplier.get();
            if (item instanceof Map) {
                jobQueue.add(createCompletableMapFuture(methodSupplier));
            } else {
                throw new UnsupportedOperationException("Just supporting map at the moment");
            }
        }
        while (!jobQueue.isEmpty()) {
            CompletableFuture<Object> future = jobQueue.poll();
            if (future == null) {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(future);
            } else {
                CompletableFuture<Object> jobInStack = stack.pop();
                if (jobInStack != null) {
                    stack.push(jobInStack.thenCombineAsync(future, (previousJob, currentJob) -> {
                        if (previousJob instanceof Map && currentJob instanceof Map) {
                            Map pj = (Map) previousJob;
                            Map cj = (Map) currentJob;
                            pj.putAll(cj);
                        }
                        return previousJob;
                    }));
                }
            }
        }

        return stack.pop();
    }

    private <T> CompletableFuture<Object> createCompletableMapFuture(Supplier<T> methodSupplier) {
        CompletableFuture<Object> completableFuture = createCompletableFuture(methodSupplier);
        return completableFuture;
    }

    private <T, S> CompletableFuture<Object> createCompletableFuture(Supplier<T> methodSupplier) {
        return CompletableFuture
                .supplyAsync(methodSupplier, executorService)
                .handle((s, e) -> {
                    if (e != null) {
                        System.err.println(e.getMessage());
                        throw new RuntimeException(e.getMessage());
                    } else {
                        return s;
                    }
                });
    }

    <T> void onComplete(Future<T> future) {

    }

    void onStarted(String jobId, long timestamp) {

    }

    public void shutdown() {
        executorService.shutdown();
    }
}