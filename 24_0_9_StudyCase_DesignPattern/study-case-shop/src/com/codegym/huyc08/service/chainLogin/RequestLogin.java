package com.codegym.huyc08.service.chainLogin;

import com.codegym.huyc08.service.Request;

public class RequestLogin implements Request {
    private String username;
    private String password;

    public RequestLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
