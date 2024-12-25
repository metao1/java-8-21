package com.metao.java8.designpatterns.dp.visitor;

public interface Configuration extends OSTypeReader {
    void config(Modem modem);
}
