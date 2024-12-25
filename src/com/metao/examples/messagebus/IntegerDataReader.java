package com.metao.examples.messagebus;

public abstract class IntegerDataReader implements DataReader<Integer>, DataReaderEvent<Integer> {

    @Override
    public Integer read() {
        Integer integer = readInteger();
        onReadSource(integer);
        return integer;
    }

    protected abstract Integer readInteger();

    abstract String getName();

}
