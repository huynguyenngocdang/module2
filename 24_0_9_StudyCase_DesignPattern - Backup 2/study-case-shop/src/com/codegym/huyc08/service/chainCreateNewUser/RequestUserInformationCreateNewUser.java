package com.codegym.huyc08.service.chainCreateNewUser;

import com.codegym.huyc08.service.RequestUserInformation;

public class RequestUserInformationCreateNewUser implements RequestUserInformation {
    private String username;
    private String password;

    public RequestUserInformationCreateNewUser(String username, String password) {
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
