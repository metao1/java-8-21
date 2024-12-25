package com.metao.java8.designpatterns.dp.abstractfactory.home;

public class ClassicHomeFactory extends AbstractHomeFactory {

    @Override
    Home composeHome() {
        return new ClassicArchitecture();
    }
}
