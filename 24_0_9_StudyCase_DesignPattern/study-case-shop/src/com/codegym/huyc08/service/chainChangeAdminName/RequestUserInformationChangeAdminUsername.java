package com.codegym.huyc08.service.chainChangeAdminName;

import com.codegym.huyc08.service.RequestUserInformation;

public class RequestUserInformationChangeAdminUsername implements RequestUserInformation {
    private String username;

    public RequestUserInformationChangeAdminUsername(String username) {
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
