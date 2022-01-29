package com.metao.java8.designpatterns.dp.decorator;

public interface DataSource<T> {
    void writeData(T data);

    T readData();
}
