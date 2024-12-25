package com.metao.examples.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ReactiveSimpleCaseTest {

    public static void main(String[] args) {
        Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6))
                .flatMap(item -> Mono.fromCallable(() -> process(item))
                        .subscribeOn(Schedulers.boundedElastic()))
                .subscribe(System.out::println);

    }

    private static void operate() {

    }

    private static void close() {
    }

    private static Integer process(Integer item) {
        item += 10;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        return item;
    }
}
