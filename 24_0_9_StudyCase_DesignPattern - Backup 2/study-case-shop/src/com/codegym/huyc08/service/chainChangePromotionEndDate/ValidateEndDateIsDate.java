package com.codegym.huyc08.service.chainChangePromotionEndDate;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegexDate;

public class ValidateEndDateIsDate implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidateEndDateIsDate(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        Validator validateDate = new ValidatorRegexDate(requestPromotion.getString());
        if(validateDate.isCheck()){
            System.out.println("Validate input is a date successfully");
            return true;
        } else {
            System.out.println("Please try again");
            return false;
        }

    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
        if (!doHandle(requestPromotion)) {
            return;
        }
        if(next!= null) {
            next.handle(requestPromotion);
        }

    }
}
