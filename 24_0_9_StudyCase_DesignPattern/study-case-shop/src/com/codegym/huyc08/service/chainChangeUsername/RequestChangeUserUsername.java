package com.codegym.huyc08.service.chainChangeUsername;

import com.codegym.huyc08.service.Request;

public class RequestChangeUserUsername implements Request {
    private String username;

    public RequestChangeUserUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
