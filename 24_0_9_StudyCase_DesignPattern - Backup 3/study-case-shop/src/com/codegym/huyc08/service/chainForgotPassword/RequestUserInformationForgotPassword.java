package com.codegym.huyc08.service.chainForgotPassword;

import com.codegym.huyc08.service.RequestUserInformation;

public class RequestUserInformationForgotPassword implements RequestUserInformation {
    private String username;

    public RequestUserInformationForgotPassword(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
