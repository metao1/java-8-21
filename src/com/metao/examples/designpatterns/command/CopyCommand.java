package com.metao.examples.designpatterns.command;

import com.metao.examples.designpatterns.dp.command.Command;
import com.metao.examples.designpatterns.dp.command.Editor;

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
