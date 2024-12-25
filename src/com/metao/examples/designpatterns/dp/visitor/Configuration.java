package com.metao.examples.designpatterns.dp.visitor;

public interface Configuration extends OSTypeReader {
    void config(Modem modem);
}
