package com.metao.examples.designpatterns.abstractfactory.home;

import com.metao.examples.designpatterns.dp.abstractfactory.home.Home;
import com.metao.examples.designpatterns.dp.abstractfactory.home.Room;

import java.math.BigDecimal;

public class ClassicArchitecture extends Home {

    @Override
    int size() {
        return 2;
    }

    @Override
    Room room() {
        return () -> BigDecimal.valueOf(1);
    }
}
