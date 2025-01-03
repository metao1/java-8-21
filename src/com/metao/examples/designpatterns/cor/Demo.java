package com.metao.examples.designpatterns.cor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Chain Of Responsibilities design pattern. Everything comes together here.*/
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("contact@onlinejavaclass.com", "mehrdad");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // Server gets a chain from client challenges.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            try {
                success = server.logIn(email, password);
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            }
        } while (!success);
    }
}