package com.metao.java8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.sqrt;
import static java.lang.Thread.sleep;
import static java.util.stream.IntStream.range;
import static java.util.stream.LongStream.rangeClosed;

public class BadPracticeParallelThreadsExample {
    private static final int MAX = 100;

    public static void main(String[] args) throws InterruptedException {
        long l = new BadPracticeParallelThreadsExample().countPrimes(10000000);
        System.out.println("l = " + l);
    }

    private long countPrimes(int max) {
        return range(1, max)
                .parallel()
                .filter(this::isPrime)
                .count();
    }

    private boolean isPrime(long n) {
        return n > 1 && rangeClosed(2, (long) sqrt(n))
                .noneMatch(divisor -> n % divisor == 0);
    }

    private void run() throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        // Simulating multiple threads in the system
        // if one of them is executing a long-running task.
        // Some of the other threads/tasks are waiting
        // for it to finish
        es.execute(() -> countPrimes(MAX, 1000)); //incorrect task
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.shutdown();
        es.awaitTermination(60, TimeUnit.SECONDS);
    }

    private void countPrimes(int max, int delay) {
        var count = range(1, max).parallel().filter(this::isPrime).peek(i -> {
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }).count();
        System.out.println("count = " + count);
    }

}
