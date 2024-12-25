package com.metao.java8.designpatterns.dp.visitor;

public interface Connector {

    void connect(Modem modem);

    boolean isConnected();
}
