package com.metao.examples;

import java.util.concurrent.atomic.AtomicInteger;

public class CountDownTest {
    public static void main(String[] args) throws InterruptedException {
        var ai = new AtomicInteger(1);
        ai.getAndIncrement();
        System.out.println(ai.get());
    }
}
