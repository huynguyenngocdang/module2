package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDateBeforeDate;
import com.codegym.huyc08.service.ValidatorRegexString;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidateNewPromotionEndDateAfterToday implements HandlerNewPromotion {
    private final Scanner SCANNER;
    private HandlerNewPromotion next;

    public ValidateNewPromotionEndDateAfterToday(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_REGEX);
        String todayDateZeroTime = dateFormat.format(new Date());
        String newEndDate = requestNewPromotion.getPromotionDateEnd();
        Validator validateEndDateAfterToday = new ValidatorDateBeforeDate(todayDateZeroTime, newEndDate );
        if(validateEndDateAfterToday.isCheck()) {
            System.out.println("Check end date after today successfully");
            return true;
        } else {
            System.out.println("End date is before today, please try again");
            return false;
        }
    }

    @Override
    public void handle(RequestNewPromotion requestNewPromotion) {
        if(!doHandle(requestNewPromotion)) {
            return;
        }
        if(next!=null){
            next.handle(requestNewPromotion);
        }
    }
}
