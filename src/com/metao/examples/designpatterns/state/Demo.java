package com.metao.examples.designpatterns.state;

import com.metao.examples.designpatterns.state.Player;
import com.metao.examples.designpatterns.state.UI;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        com.metao.examples.designpatterns.state.UI ui = new UI(player);
        ui.init();
    }
}
