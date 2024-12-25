package com.metao.examples.designpatterns.command;

import com.metao.examples.designpatterns.command.Editor;

public abstract class Command {
    public com.metao.examples.designpatterns.command.Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}
