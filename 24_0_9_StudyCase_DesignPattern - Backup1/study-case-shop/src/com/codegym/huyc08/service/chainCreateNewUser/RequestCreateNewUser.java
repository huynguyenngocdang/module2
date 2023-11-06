package com.codegym.huyc08.service.chainCreateNewUser;

import com.codegym.huyc08.service.Request;

public class RequestCreateNewUser implements Request {
    private String username;
    private String password;

    public RequestCreateNewUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
}
