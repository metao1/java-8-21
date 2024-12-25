package com.metao.examples.messagebus;

public interface DataReaderEvent<I> {
    void onReadSource(I in);
}
