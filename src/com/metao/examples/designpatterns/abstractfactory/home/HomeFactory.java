package com.metao.examples.designpatterns.abstractfactory.home;

import com.metao.examples.designpatterns.abstractfactory.home.Home;

public class HomeFactory {

    static Home composeHome(AbstractHomeFactory abstractHomeFactory) {
        return abstractHomeFactory.composeHome();
    }
}
