package com.metao.examples.reactive;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ReactiveBackgroundTest {

    public static void main(String[] args) throws InterruptedException {
        subscribeOnWithPublishOnTest();
    }

    public static void subscribeOnWithPublishOnTest() throws InterruptedException {
        Flux.range(1, 3)
                .map(v -> debug(v, "map1"))
                .publishOn(Schedulers.parallel())
                .map(v -> debug(v * 100, "map2"))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(w -> debug(w, "subscribe"));

        Thread.sleep(5000);
    }

    private static Integer debug(Integer v, String map1) {
        System.out.println(map1 + ":" + v);
        return v;
    }
}
