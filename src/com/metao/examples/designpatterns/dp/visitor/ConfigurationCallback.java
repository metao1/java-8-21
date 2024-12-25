package com.metao.examples.designpatterns.dp.visitor;

public interface ConfigurationCallback {

    void accept(Modem modem, Configuration configuration);
}
