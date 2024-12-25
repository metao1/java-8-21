package com.metao.examples.designpatterns.factory.exp1;

public abstract class Dialog implements Button {

    public void renderWindow() {
        // ... other challenges ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
