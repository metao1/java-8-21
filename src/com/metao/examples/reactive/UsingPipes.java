//package com.metao.java8.reactive;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.core.scheduler.Scheduler;
//import reactor.core.scheduler.Schedulers;
//
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Stream;
//
//public class UsingPipes {
//    public static void main(String[] args) throws InterruptedException {
//        new UsingPipes()
//                .blockingToNonBlockingRightWay()
//                .subscribe(System.out::println);
//    }
//
//    private final Scheduler scheduler = Schedulers.newParallel("thread", 16);
//
//    public Mono<String> getInfoCallable(Integer a) {
//        return Mono
//                .fromCallable(() -> blockingGetInfo(a)).subscribeOn(scheduler);// Define blocking call
//    }
//
//    public static void delay() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String blockingGetInfo(Integer input) {
//        delay();
//        return String.format("[%d] on thread [%s] at time [%s]", input, Thread.currentThread().getName(), new Date());
//    }
//
//    public Flux<String> blockingToNonBlockingRightWay() {
//        return Flux.fromStream(Stream.of(1, 2, 3, 4))
//
//                .flatMap(this::getInfoCallable)
//                .subscribeOn(Schedulers.elastic())
//                ; // Define the execution model ;
//
//    }
//
//}
