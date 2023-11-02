package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorAdmin implements Validator{
    private String username;
    private String regex;
    public ValidatorAdmin(String username) {
        this.username = username;
        this.regex = Constants.ADMIN_REGEX;
    }

    @Override
    public boolean isCheck() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
