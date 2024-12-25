package com.metao.examples.designpatterns.cor;

import com.metao.examples.designpatterns.dp.cor.Middleware;

import java.io.IOException;

/* ConcreteHandler. Checks a user's role.*/
public class RoleCheckMiddleware extends Middleware {
    public boolean check(String email, String password) throws IOException {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}