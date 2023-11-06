package com.codegym.huyc08.service.chainChangePromotionEndDate;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDateBeforeDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ValidateEndDateAfterToday implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidateEndDateAfterToday(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_REGEX);
        String todayDateZeroTime = dateFormat.format(new Date());
        String newEndDate = requestPromotion.getString();
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
    public void handle(RequestPromotion requestPromotion) {
        if(!doHandle(requestPromotion)){
            return;
        }
        if(next!=null){
            next.handle(requestPromotion);
        }
    }
}
