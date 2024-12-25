package com.metao.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadSafety {

    private class SumArea {
        private int sum = 0;

        private void calc() {
            sum += 1;
        }
    }

    public ThreadSafety() throws InterruptedException {
        ThreadSafety.SumArea ts = new SumArea();
        ExecutorService es = Executors.newFixedThreadPool(4);
        IntStream.range(0, 1000)
                .forEach(num -> es.submit(ts::calc));

        boolean b = es.awaitTermination(300, TimeUnit.MILLISECONDS);

        assert ts.sum == 1000;
        System.out.println(ts.sum);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafety threadSafety = new ThreadSafety();

    }
}
