package com.metao.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ThenCompose {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture
                .supplyAsync(ThenCompose::doSomethingAndReturnA)
                .thenCombine(CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "1";
                }), (v1, v2) -> v1)
                .thenCombine(CompletableFuture.supplyAsync(() -> "1"), (v1, v2) -> v1);

        String s = stringCompletableFuture.get();
        System.out.println(s);
    }

    private static int convertToB(final String a) {
        System.out.println("convertToB: " + Thread.currentThread().getName());
        return Integer.parseInt(a);
    }

    private static String doSomethingAndReturnA() {
        System.out.println("doSomethingAndReturnA: " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "1";
    }
}
