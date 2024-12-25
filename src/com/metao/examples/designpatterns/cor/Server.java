package com.metao.examples.designpatterns.cor;

import com.metao.examples.designpatterns.dp.cor.Middleware;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** Server class.*/
public class Server {
    private final Map<String,String> users = new HashMap<>();
    private Middleware middleware;

    /**Client passes a chain of object to server. This improves flexibility and makes testing the server class easier.*/
    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    /**Server gets email and password from client and sends the authorization request to the chain.*/
    public boolean logIn(String email, String password) throws IOException {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.

            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}