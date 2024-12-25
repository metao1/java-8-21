package com.metao.examples.designpatterns.factory.exp1;

public abstract class Dialog implements com.metao.examples.designpatterns.factory.exp1.Button {

    public void renderWindow() {
        // ... other challenges ...

        com.metao.examples.designpatterns.factory.exp1.Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
