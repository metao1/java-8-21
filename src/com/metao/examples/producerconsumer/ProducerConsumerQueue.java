package com.metao.examples.producerconsumer;

import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProducerConsumerQueue {


    public static void main(String[] args) throws InterruptedException {
        DataInterface<Integer> dataHandler = new DataHandler<>();
        try(ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2, Executors.defaultThreadFactory())) {
            EventHandler<Integer> producerEventHandler = new ProducerEventHandler(dataHandler);
            EventHandler<Integer> consumerEventHandler = new ConsumerEventHandler<>(dataHandler);
            executorService.scheduleAtFixedRate(producerEventHandler, 0, 1, TimeUnit.SECONDS);
            executorService.scheduleAtFixedRate(consumerEventHandler, 1, 1, TimeUnit.SECONDS);
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            producerEventHandler.cancel();
            consumerEventHandler.cancel();
            executorService.shutdown();
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
        private final BlockingQueue<T> queue;
        private final static AtomicBoolean stopped = new AtomicBoolean(false);

        public DataHandler() {
            this.queue = new LinkedBlockingQueue<>();
        }

        public DataHandler(int queueSize) {
            if (queueSize <= 0) {
                throw new IllegalStateException("queue size must be positive");
            }
            this.queue = new LinkedBlockingQueue<>(queueSize);
        }

        @Override
        public void accept(T t) {
            if (stopped.get()) {
                return;
            }
            final boolean offered;
            try {
                offered = this.queue.offer(t, 100, TimeUnit.MILLISECONDS);
                if (!offered) {
                    throw new InterruptedException("could not insert into queue due to data ingestion.");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException("could not insert into queue due to timeout reached.");
            }
        }

        @Override
        public T get() {
            if (!stopped.get()) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            throw new NullPointerException("data handler is stopped.No data is available.");
        }

        @Override
        public void stop() {
            DataHandler.stopped.set(true);
        }
    }

    private interface DataInterface<T> extends Consumer<T>, Supplier<T> {
        void stop();
    }


}
