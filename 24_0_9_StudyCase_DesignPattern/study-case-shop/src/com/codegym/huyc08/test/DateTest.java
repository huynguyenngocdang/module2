package com.codegym.huyc08.test;

import com.codegym.huyc08.constant.AppConstant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Calculate the beginning of the previous week
        LocalDate beginningOfPreviousWeek = today.minusWeeks(1)

                .atStartOfDay()
                .toLocalDate();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConstant.DATE_PATTERN_REGEX);
        String previousWeek = dateTimeFormatter.format(beginningOfPreviousWeek);

        System.out.println("Beginning of previous week with zero time: " + beginningOfPreviousWeek);
        System.out.println(previousWeek);
    }
}
