package com.metao.examples.designpatterns.abstractfactory.home;

import com.metao.examples.designpatterns.dp.abstractfactory.home.HomeFactory;

public class DemoHome {
    public static void main(String[] args) {
        var classicHome = HomeFactory.composeHome(new ClassicHomeFactory());
        var modernHome = HomeFactory.composeHome(new ModernHomeFactory());
    }
}
