package com.codegym.huyc08.service;

public abstract class Handler {
    private Handler next;

    public Handler(Handler next) {
        this.next = next;
    }
    public void handle(LoginRequest request) {
        if(doHandle(request)) {
            return;
        }
        if(next != null) {
            next.handle(request);
        }
    }
    public abstract boolean doHandle(LoginRequest request);
}
