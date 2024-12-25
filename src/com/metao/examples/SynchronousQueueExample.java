package com.metao.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronousQueueExample {

    AtomicInteger integer = new AtomicInteger();
    CountDownLatch latch = new CountDownLatch(1);
    SynchronousQueue<Integer> syncQueue = new SynchronousQueue<>();

    ExecutorService executor  = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        new SynchronousQueueExample().countDownLatch();
        new SynchronousQueueExample().synchronousQueue();
    }

    private void synchronousQueue() throws InterruptedException {
        Callable<Integer> producer = () -> {
            int anInt = ThreadLocalRandom.current().nextInt(10, 20);
            System.out.println("producing...");
            syncQueue.put(anInt);
            return anInt;
        };

        Callable<Integer> consumer = () -> {
            try {
                Integer take = syncQueue.take();
                System.out.println("consuming...");
                return take;
            } catch (InterruptedException toe) {
                System.out.println(toe.getMessage());
            }
            return null;
        };
        executor.submit(consumer);
        executor.submit(producer);
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();
    }

    public void countDownLatch() throws InterruptedException {

        Callable<Integer> producer = () -> {
            int anInt = ThreadLocalRandom.current().nextInt(10, 20);
            System.out.println("producing...");
            integer.set(anInt);
            latch.countDown();
            return anInt;
        };

        Callable<Integer> consumer = () -> {
            try {
                latch.await(10, TimeUnit.SECONDS);
                System.out.println("consuming...");
                return integer.get();
            } catch (InterruptedException toe) {
                System.out.println(toe.getMessage());
            }
            return null;
        };

        executor.submit(consumer);
        executor.submit(producer);
        executor.awaitTermination(10, TimeUnit.SECONDS);


        executor.shutdown();

    }
}
