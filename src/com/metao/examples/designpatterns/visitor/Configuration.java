package com.metao.examples.designpatterns.visitor;

public interface Configuration extends OSTypeReader {
    void config(Modem modem);
}
