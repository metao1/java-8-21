package com.metao.examples.designpatterns.dp.abstractfactory.home;

public class ClassicHomeFactory extends AbstractHomeFactory {

    @Override
    Home composeHome() {
        return new ClassicArchitecture();
    }
}
