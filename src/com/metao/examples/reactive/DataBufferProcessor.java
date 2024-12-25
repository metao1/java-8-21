package com.metao.examples.reactive;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DataBufferProcessor implements DataBuffer {

    BlockingQueue<ByteBuffer> queue = new LinkedBlockingQueue<>(255);

    @Override
    public boolean isAvailable() {
        return !queue.isEmpty();
    }

    @Override
    public BlockingQueue<Message> readFromQueue() {
        return null;
    }
}
