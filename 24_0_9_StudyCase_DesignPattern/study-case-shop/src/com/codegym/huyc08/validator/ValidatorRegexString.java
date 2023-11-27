package com.codegym.huyc08.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorRegexString implements Validator{
    private String name;
    private String regex;

    public ValidatorRegexString(String name, String regex) {
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
