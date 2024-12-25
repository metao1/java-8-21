package com.metao.examples.designpatterns.abstractfactory.home;

import com.metao.examples.designpatterns.abstractfactory.home.Home;

public class ModernHomeFactory extends AbstractHomeFactory {

    @Override
    Home composeHome() {
        return new ModernArchitecture();
    }
}
