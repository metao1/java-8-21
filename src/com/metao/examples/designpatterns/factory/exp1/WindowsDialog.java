package com.metao.examples.designpatterns.factory.exp1;

import com.metao.examples.designpatterns.dp.factory.exp1.Button;
import com.metao.examples.designpatterns.dp.factory.exp1.Dialog;
import com.metao.examples.designpatterns.dp.factory.exp1.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public void render() {

    }

    @Override
    public void onClick() {

    }
}
