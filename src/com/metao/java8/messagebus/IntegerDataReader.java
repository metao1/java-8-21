package com.metao.java8.messagebus;

import java.util.Random;

public abstract class IntegerDataReader implements DataReader<Object>, DataReaderEvent<Object> {

    private final Random random = new Random();

    @Override
    public Integer read() {
        int in = random.ints(1, 100).findFirst().getAsInt();
        onReadSource(in);
        return in;
    }

    abstract String getName();

}
