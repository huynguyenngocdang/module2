package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.NormalUser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUser implements Validator {
    private String username;
    private String regex;
    public ValidatorUser(String username) {
        this.username = username;
        this.regex = Constants.USER_REGEX;
    }

    @Override
    public boolean isCheck() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
