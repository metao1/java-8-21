package com.metao.examples.designpatterns.decorator;

public class DataSourceDecorator implements DataSource<String> {
    private final DataSource<String> wrappee;

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
