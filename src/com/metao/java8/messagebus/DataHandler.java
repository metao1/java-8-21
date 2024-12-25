package com.metao.java8.messagebus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class DataHandler<T> implements DataInterface<T> {
    private final static AtomicBoolean stopped = new AtomicBoolean(false);
    private final Queue<T> queue;

    public DataHandler() {
        this.queue = new LinkedList<>();
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
            offered = this.queue.offer(t);
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
            return queue.poll();
        }
        throw new NullPointerException("data handler is stopped.No data is available.");
    }

    @Override
    public void stop() {
        DataHandler.stopped.set(true);
    }
}