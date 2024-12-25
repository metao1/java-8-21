package com.metao.examples.designpatterns.abstractfactory.home;

public class HomeFactory {

    static Home composeHome(AbstractHomeFactory abstractHomeFactory) {
        return abstractHomeFactory.composeHome();
    }
}
