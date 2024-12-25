package com.metao.java8.designpatterns.dp.abstractfactory.home;

public class HomeFactory {

    static Home composeHome(AbstractHomeFactory abstractHomeFactory) {
        return abstractHomeFactory.composeHome();
    }
}
