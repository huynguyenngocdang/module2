package com.codegym.huyc08.service.chainChangePromotionStartDate;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorRegexDate;

public class ValidateStartDateIsDate implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateStartDateIsDate(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        Validator validateDate = new ValidatorRegexDate(requestModifyPromotion.getPromotionDateStart());
        if(validateDate.isCheck()){
            System.out.println("Validate input is a date successfully");
            return true;
        } else {
            System.out.println("Please try again");
            return false;
        }

    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if (!doHandle(requestModifyPromotion)) {
            return;
        }
        if(next!= null) {
            next.handle(requestModifyPromotion);
        }

    }
}
