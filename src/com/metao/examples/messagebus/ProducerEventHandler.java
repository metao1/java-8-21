package com.metao.examples.messagebus;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

abstract class ProducerEventHandler<T, DR> extends EventHandler<DR> {

    private final List<DataReader<DR>> dataReader;
    private final String name;
    private final DataHandler<T> dataHandler;

    ProducerEventHandler(String name, DataHandler<T> dataHandler) {
        this.dataReader = new LinkedList<>();
        this.dataHandler = dataHandler;
        this.name = name;
    }

    ProducerEventHandler(DataHandler<T> dataHandler) {
        this("producer-".concat(Thread.currentThread().getName()), dataHandler);
    }

    @Override
    public void run() {
        for (DataReader<DR> dataReader : dataReader) {
            DR read = dataReader.read();
            T data = convert(read);
            dataHandler.accept(data);
            System.out.println(name + ", produced:" + read);
        }
    }

    abstract T convert(DR data);

    T convert(DR in, Function<DR, T> mapper) {
        return mapper.apply(in);
    }

    public void addMessageReader(DataReader<DR> dataReader) {
        this.dataReader.add(dataReader);
    }
}
