package com.metao.java8.designpatterns.dp.visitor;


public interface Modem {
    void config(Configuration configuration);

    void connect(Connector connector);

    void disconnect();

    byte[] read();

    void write(byte[] data);

    ModemModel getModel();
}
