package com.metao.examples.designpatterns.dp.visitor;

public interface Connector {

    void connect(Modem modem);

    boolean isConnected();
}
