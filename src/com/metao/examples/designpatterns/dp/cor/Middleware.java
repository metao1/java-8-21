package com.metao.examples.designpatterns.dp.cor;

import java.io.IOException;

/* Base middleware class.*/
public abstract class Middleware {
    private Middleware next;

    /* Builds chains of middleware objects.*/
    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }


    /* Subclasses will implement this method with concrete checks.*/
    public abstract boolean check(String email, String password) throws IOException;

    /* Runs check on the next object in chain or ends traversing if we're in */
    /* last object in chain.*/
    protected boolean checkNext(String email, String password) throws IOException{
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
