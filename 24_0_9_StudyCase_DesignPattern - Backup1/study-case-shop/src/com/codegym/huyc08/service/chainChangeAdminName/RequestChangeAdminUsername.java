package com.codegym.huyc08.service.chainChangeAdminName;

import com.codegym.huyc08.service.Request;

public class RequestChangeAdminUsername implements Request {
    private String username;

    public RequestChangeAdminUsername(String username) {
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
