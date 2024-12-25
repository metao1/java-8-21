package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.visitor.Modem;

public interface Connector {

    void connect(Modem modem);

    boolean isConnected();
}
