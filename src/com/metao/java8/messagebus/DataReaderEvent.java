package com.metao.java8.messagebus;

public interface DataReaderEvent<I> {
    void onReadSource(I in);
}
