package com.metao.examples.designpatterns.visitor;

public interface ConfigurationCallback {

    void accept(Modem modem, Configuration configuration);
}
