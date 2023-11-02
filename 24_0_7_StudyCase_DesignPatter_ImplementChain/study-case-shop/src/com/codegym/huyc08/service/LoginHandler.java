package com.codegym.huyc08.service;

public abstract class LoginHandler {
    private LoginHandler next;

    public LoginHandler(LoginHandler next) {
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
