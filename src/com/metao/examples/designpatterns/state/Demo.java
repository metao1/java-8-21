package com.metao.examples.designpatterns.state;

import com.metao.examples.designpatterns.dp.state.Player;
import com.metao.examples.designpatterns.dp.state.UI;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        com.metao.examples.designpatterns.dp.state.UI ui = new UI(player);
        ui.init();
    }
}
