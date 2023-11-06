package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidatorDateBeforeDate implements Validator{
    private String startDate;
    private String endDate;
    private SimpleDateFormat format;

    public ValidatorDateBeforeDate(String startDate, String endDate) {
        this.format = new SimpleDateFormat(Constants.DATE_PATTERN_REGEX);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isCheck() {
        try {
            Date dateStart = format.parse(startDate);
            Date dateEnd = format.parse(endDate);
            return (dateStart.compareTo(dateEnd)<= 0);
        } catch (ParseException e){
            return false;
        }
    }
}
