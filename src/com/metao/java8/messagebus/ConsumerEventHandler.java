package com.metao.java8.messagebus;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

abstract class ConsumerEventHandler<DR> extends EventHandler<DR> {

    private final List<DataReader<DR>> dataReader;
    private final String name;
    private final DataHandler<DR> dataHandler;

    ConsumerEventHandler(String name, DataHandler<DR> dataHandler) {
        this.dataReader = new LinkedList<>();
        this.dataHandler = dataHandler;
        this.name = name;
    }

    ConsumerEventHandler(DataHandler<DR> dataHandler) {
        this("consumer-".concat(Thread.currentThread().getName()), dataHandler);
    }


    @Override
    public void run() {
        DR dr;
        try {
            while ((dr = dataHandler.get()) != null) {
                Iterator<ConsumerEventListener<DR>> iterator = dataListeners.iterator();
                while (iterator.hasNext()) {
                    ConsumerEventListener<DR> next = iterator.next();
                    next.onRead(dr);
                }
            }
        }catch (Exception e){
            onException(e);
        }
    }

    public void addConsumer(ConsumerEventListener<DR> dataInterface) {
        this.dataListeners.add(dataInterface);
    }

    protected abstract void onException(Exception ex);

}