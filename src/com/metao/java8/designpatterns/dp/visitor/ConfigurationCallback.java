package com.metao.java8.designpatterns.dp.visitor;

public interface ConfigurationCallback {

    void accept(Modem modem, Configuration configuration);
}
