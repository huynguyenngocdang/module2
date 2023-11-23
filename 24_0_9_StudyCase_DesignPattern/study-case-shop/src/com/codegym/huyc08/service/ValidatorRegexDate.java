package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.AppConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidatorRegexDate implements Validator{
    private final SimpleDateFormat dateFormat;
    private String stringDate;

    public ValidatorRegexDate(String stringDate) {
        this.dateFormat = new SimpleDateFormat(AppConstant.DATE_PATTERN_REGEX);
        this.stringDate = stringDate;
    }

    @Override
    public boolean isCheck() {
        if (stringDate == null || !stringDate.matches(AppConstant.DATE_REGEX)) {
            return false;
        }
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(stringDate);
            return true;

        } catch (ParseException e){
            return false;
        }
    }
}
