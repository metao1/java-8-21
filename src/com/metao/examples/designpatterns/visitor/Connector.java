package com.metao.examples.designpatterns.visitor;

public interface Connector {

    void connect(Modem modem);

    boolean isConnected();
}
