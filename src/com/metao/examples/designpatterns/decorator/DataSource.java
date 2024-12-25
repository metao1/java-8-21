package com.metao.examples.designpatterns.decorator;

public interface DataSource<T> {
    void writeData(T data);

    T readData();
}
