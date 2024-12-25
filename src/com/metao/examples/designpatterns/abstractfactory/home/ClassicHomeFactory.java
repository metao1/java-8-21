package com.metao.examples.designpatterns.abstractfactory.home;

import com.metao.examples.designpatterns.dp.abstractfactory.home.Home;

public class ClassicHomeFactory extends AbstractHomeFactory {

    @Override
    Home composeHome() {
        return new ClassicArchitecture();
    }
}
