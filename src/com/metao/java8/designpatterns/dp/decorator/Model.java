package com.metao.java8.designpatterns.dp.decorator;

import java.io.Serializable;

public class Model implements Serializable {

    private String data;

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
