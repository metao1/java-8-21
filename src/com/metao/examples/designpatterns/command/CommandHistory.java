package com.metao.examples.designpatterns.command;

import com.metao.examples.designpatterns.dp.command.Command;

import java.util.Stack;

public class CommandHistory {
    private Stack<com.metao.examples.designpatterns.dp.command.Command> history = new Stack<>();

    public void push(com.metao.examples.designpatterns.dp.command.Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
