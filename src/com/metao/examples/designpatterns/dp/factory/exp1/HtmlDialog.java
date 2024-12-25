package com.metao.examples.designpatterns.dp.factory.exp1;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }

    @Override
    public void render() {

    }

    @Override
    public void onClick() {

    }
}
