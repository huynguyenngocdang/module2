package com.codegym.huyc08.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorRegex implements Validator{
    private String name;
    private String regex;

    public ValidatorRegex(String name, String regex) {
        this.name = name;
        this.regex = regex;
    }

    @Override
    public boolean isCheck() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
