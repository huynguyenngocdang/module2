package com.codegym.huyc08.service.chainChangeUsername;

import com.codegym.huyc08.service.RequestUserInformation;

public class RequestUserInformationChangeUserUsername implements RequestUserInformation {
    private String username;

    public RequestUserInformationChangeUserUsername(String username) {
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
