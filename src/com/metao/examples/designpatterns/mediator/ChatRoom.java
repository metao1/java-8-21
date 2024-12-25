package com.metao.examples.designpatterns.mediator;

import com.metao.examples.designpatterns.dp.mediator.User;

import java.util.Date;

public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString()
                + " [" + user.getName() + "] : " + message);
    }
}