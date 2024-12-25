package com.metao.examples.designpatterns.solid.fixed;

import com.metao.examples.designpatterns.solid.fixed.Keyboard;
import com.metao.examples.designpatterns.solid.fixed.Monitor;

public class Windows98Machine {

    private final com.metao.examples.designpatterns.solid.fixed.Keyboard keyboard;
    private final com.metao.examples.designpatterns.solid.fixed.Monitor monitor;

    public Windows98Machine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}