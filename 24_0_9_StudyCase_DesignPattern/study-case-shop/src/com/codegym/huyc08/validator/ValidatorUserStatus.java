package com.codegym.huyc08.validator;

import com.codegym.huyc08.service.SingletonCurrentUser;

public class ValidatorUserStatus implements Validator{
    @Override
    public boolean isCheck() {
        return SingletonCurrentUser.getInstance().getCurrentUserStatus();
    }
}
