package com.metao.java8.reactive;

import java.util.concurrent.BlockingQueue;

public interface DataBuffer {

    boolean isAvailable();

    BlockingQueue<Message> readFromQueue();
}