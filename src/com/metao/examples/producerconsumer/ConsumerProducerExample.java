package com.metao.examples.producerconsumer;

import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerProducerExample {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        DataInterface<Integer> dataHandler = new DataHandler<>();
        EventHandler<Integer> producerEventHandler = new ProducerEventHandler(dataHandler);
        EventHandler<Integer> consumerEventHandler = new ConsumerEventHandler<>(dataHandler);

        executorService.scheduleAtFixedRate(producerEventHandler, 0, 1L, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(consumerEventHandler, 1, 1L, TimeUnit.SECONDS);
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        producerEventHandler.cancel();
        consumerEventHandler.cancel();
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

    private static class DataHandler<T> implements DataInterface<T> {
        private final AtomicReference<T> data = new AtomicReference<>();
        private final static AtomicBoolean stopped = new AtomicBoolean(false);

        @Override
        public void accept(T t) {
            if (stopped.get()) {
                return;
            }
            this.data.set(t);
        }

        @Override
        public T get() {
            if (!stopped.get()) {
                return data.get();
            }
            throw new NullPointerException("data handler is stopped.No data is available.");
        }

        @Override
        public void stop() {
            DataHandler.stopped.set(true);
        }
    }
}
