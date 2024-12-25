package com.metao.examples.designpatterns.dp.abstractfactory;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}