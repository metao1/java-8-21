package com.metao.java8.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static com.metao.java8.reactive.UsingPipes.blockingGetInfo;

public class NonBlockingReactiveTest {

    public static void main(String[] args) {
        blockingToNonBlockingRightWay()
                .subscribe(System.out::println);
    }

    public static Mono<String> getInfoCallable(Integer a) {
        // Returns a non-blocking Publisher with a Single Value (Mono)
        return Mono
                .fromCallable(() -> blockingGetInfo(a)) // Define blocking call
                .subscribeOn(Schedulers.elastic()); // Define the execution model
    }

    public static Flux<String> blockingToNonBlockingRightWay() {
        return Flux.range(1, 10)
                .flatMap(NonBlockingReactiveTest::getInfoCallable);

    }
}
