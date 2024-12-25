package com.metao.examples.designpatterns.decorator;

import com.metao.examples.designpatterns.decorator.DataSource;

public class DataSourceDecorator implements com.metao.examples.designpatterns.decorator.DataSource<String> {
    private final com.metao.examples.designpatterns.decorator.DataSource<String> wrappee;

    DataSourceDecorator(DataSource<String> source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
