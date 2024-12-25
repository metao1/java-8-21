package com.metao.examples.designpatterns.cor;

import com.metao.examples.designpatterns.dp.cor.Middleware;

import java.io.IOException;

public class ThrottlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    /* Please, not that checkNext() call can be inserted both in the beginning of this method and in the end.. */
    public boolean check(String email, String password) throws IOException {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            throw new IOException("Request limit exceeded!");
        }
        return checkNext(email, password);
    }
}