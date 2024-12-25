package com.metao.examples.reactive;

import java.util.concurrent.BlockingQueue;

public interface DataBuffer {

    boolean isAvailable();

    BlockingQueue<Message> readFromQueue();
}