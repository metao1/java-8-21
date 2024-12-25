package com.metao.examples.designpatterns.abstractfactory;

import com.metao.examples.designpatterns.dp.abstractfactory.Computer;
import com.metao.examples.designpatterns.dp.abstractfactory.Server;

public class ServerFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram,hdd,cpu);
    }

}