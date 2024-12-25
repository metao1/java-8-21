package com.metao.examples.designpatterns.cor;

import com.metao.examples.designpatterns.cor.Middleware;
import com.metao.examples.designpatterns.cor.Server;

import java.io.IOException;

/* ConcreteHandler. Checks whether a user with the given credentials exists.*/
public class UserExistsMiddleware extends Middleware {
    private com.metao.examples.designpatterns.cor.Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) throws IOException {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}