package com.metao.examples.designpatterns.factory.exp1;

import com.metao.examples.designpatterns.dp.factory.exp1.Button;

public abstract class Dialog implements com.metao.examples.designpatterns.dp.factory.exp1.Button {

    public void renderWindow() {
        // ... other challenges ...

        com.metao.examples.designpatterns.dp.factory.exp1.Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
