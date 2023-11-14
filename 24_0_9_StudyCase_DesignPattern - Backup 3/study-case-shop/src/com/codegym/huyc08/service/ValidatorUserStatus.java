package com.codegym.huyc08.service;

public class ValidatorUserStatus implements Validator{
    @Override
    public boolean isCheck() {
        return SingletonCurrentUser.getInstance().getCurrentUserStatus();
    }
}
