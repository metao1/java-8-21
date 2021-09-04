package com.metao.java8.consumer;

import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerExample {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        DataInterface<Integer> consumerHandler = new ConsumerHandler<>();
        Runnable producerEventHandler = new ProducerEventHandler(consumerHandler);
        Runnable consumerEventHandler = new ConsumerEventHandler<>(consumerHandler);

        executorService.scheduleAtFixedRate(producerEventHandler, 0, 1L, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(consumerEventHandler, 1, 1L, TimeUnit.SECONDS);
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    private static class ProducerEventHandler extends EventHandler<Integer> {

        private final DataInterface<Integer> dataInterface;
        private final Random random = new Random();

        private ProducerEventHandler(DataInterface<Integer> dataInterface) {
            super(dataInterface);
            this.dataInterface = dataInterface;
        }

        @Override
        public void run() {
            int i = random.ints(0, 10).findFirst().getAsInt();
            System.out.println("producer " + Thread.currentThread().getName() + ":" + i);
            dataInterface.accept(i);
        }
    }

    private static class ConsumerEventHandler<T> extends EventHandler<T> {

        private final DataInterface<T> dataInterface;

        public ConsumerEventHandler(DataInterface<T> dataInterface) {
            super(dataInterface);
            this.dataInterface = dataInterface;
        }

        @Override
        public void run() {
            System.out.println("consumer " + Thread.currentThread().getName() + ":" + dataInterface.get());
        }
    }

    private interface DataInterface<T> extends Consumer<T>, Supplier<T> {
        void stop();
    }

    private static abstract class EventHandler<T> extends TimerTask {
        private final DataInterface<T> dataInterface;

        EventHandler(DataInterface<T> dataInterface) {
            this.dataInterface = dataInterface;
        }

        @Override
        public boolean cancel() {
            this.dataInterface.stop();
            return super.cancel();
        }
    }


    private static class ConsumerHandler<T> implements DataInterface<T> {
        private T data;
        private final static AtomicBoolean stopped = new AtomicBoolean(false);
        private final Object lock = new Object();

        @Override
        public void accept(T t) {
            if (stopped.get()) {
                return;
            }
            synchronized (lock) {
                this.data = t;
            }
        }

        @Override
        public T get() {
            if (stopped.get()) {
                return null;
            }
            synchronized (lock) {
                return data;
            }
        }

        @Override
        public void stop() {
            ConsumerHandler.stopped.set(true);
        }
    }
}
