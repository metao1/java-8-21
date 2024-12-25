package com.metao.examples.messagebus;

import java.util.UUID;

public abstract class StringDataReader implements DataReader<Object>, DataReaderEvent<Object> {

    @Override
    public String read() {
        String s = UUID.randomUUID().toString().replace("-", "");
        onReadSource(s);
        return s;
    }

    abstract String getName();
}
