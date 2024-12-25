package com.metao.examples.designpatterns.abstractfactory.home;

public class ClassicHomeFactory extends AbstractHomeFactory {

    @Override
    Home composeHome() {
        return new ClassicArchitecture();
    }
}
