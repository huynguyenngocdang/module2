package com.codegym.huyc08.service;

public abstract class LoginHandler {
    private LoginHandler next;

    public LoginHandler(LoginHandler next) {
        this.next = next;
    }
    public abstract boolean doHandle(LoginRequest request);
    public void handle(LoginRequest request) {
        if(doHandle(request)){
            return;
        }
        if(next != null) {
            next.handle(request);
        }
    }
}
