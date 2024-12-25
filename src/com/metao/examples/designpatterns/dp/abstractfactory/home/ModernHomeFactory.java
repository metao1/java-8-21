package com.metao.examples.designpatterns.dp.abstractfactory.home;

public class ModernHomeFactory extends AbstractHomeFactory {

    @Override
    Home composeHome() {
        return new ModernArchitecture();
    }
}
