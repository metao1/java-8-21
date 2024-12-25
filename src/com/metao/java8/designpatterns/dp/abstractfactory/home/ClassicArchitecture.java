package com.metao.java8.designpatterns.dp.abstractfactory.home;

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
