package com.metao.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BitBucketAlgorithm {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new BitBucketAlgorithm();
    }

    public BitBucketAlgorithm() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<Future<Double>> futures;

        List<Callable<Double>> callableList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            callableList.add(() -> new Producer().get());
        }

        futures = executorService.invokeAll(callableList);

        Map<String, Double> me = new HashMap<>(), me2 = new HashMap<>();
        for (Future<Double> future : futures) {
            me.put(String.valueOf(future.get()), future.get());
            me2.put(String.valueOf(future.get()), future.get());
        }

        executorService.shutdown();
        Map<String, Double> collect = Stream.concat(me.entrySet().stream(), me2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v2));
        System.out.println(collect);
    }

    private static final class Producer implements Supplier<Double> {

        @Override
        public Double get() {
            return Math.random();
        }
    }
}
