package com.codegym.huyc08.service.chainLogin;

import com.codegym.huyc08.service.RequestUserInformation;

public class RequestUserInformationLogin implements RequestUserInformation {
    private String username;
    private String password;

    public RequestUserInformationLogin(String username, String password) {
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
