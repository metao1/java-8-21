package com.metao.examples.designpatterns.command;

import com.metao.examples.designpatterns.command.Command;
import com.metao.examples.designpatterns.command.Editor;

public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
