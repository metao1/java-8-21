package com.metao.examples.designpatterns.abstractfactory.home;

import com.metao.examples.designpatterns.dp.abstractfactory.home.Home;
import com.metao.examples.designpatterns.dp.abstractfactory.home.Room;

public class ModernArchitecture extends Home {
    @Override
    int size() {
        return 0;
    }

    @Override
    Room room() {
        return null;
    }
}
