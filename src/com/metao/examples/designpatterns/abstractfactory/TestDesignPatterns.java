package com.metao.examples.designpatterns.abstractfactory;

import com.metao.examples.designpatterns.dp.abstractfactory.Computer;
import com.metao.examples.designpatterns.dp.abstractfactory.ComputerFactory;
import com.metao.examples.designpatterns.dp.abstractfactory.PCFactory;
import com.metao.examples.designpatterns.dp.abstractfactory.ServerFactory;

public class TestDesignPatterns {

    public static void main(String[] args) {
        com.metao.examples.designpatterns.dp.abstractfactory.Computer pc = com.metao.examples.designpatterns.dp.abstractfactory.ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}