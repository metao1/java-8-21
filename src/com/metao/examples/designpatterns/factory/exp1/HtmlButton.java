package com.metao.examples.designpatterns.factory.exp1;

import com.metao.examples.designpatterns.dp.factory.exp1.Button;

public class HtmlButton implements Button {

    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
