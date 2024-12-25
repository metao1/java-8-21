package com.metao.examples.designpatterns.factory.exp1;

import com.metao.examples.designpatterns.dp.factory.exp1.Button;
import com.metao.examples.designpatterns.dp.factory.exp1.Dialog;
import com.metao.examples.designpatterns.dp.factory.exp1.HtmlButton;

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
