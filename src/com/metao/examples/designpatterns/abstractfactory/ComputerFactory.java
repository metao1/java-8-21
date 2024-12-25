package com.metao.examples.designpatterns.abstractfactory;

import com.metao.examples.designpatterns.dp.abstractfactory.Computer;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}