package com.codegym.huyc08.service.chainChangePromotionStartDate;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegexDate;
import com.codegym.huyc08.service.ValidatorRegexString;

public class ValidateStartDateFollowRegex implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidateStartDateFollowRegex(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        Validator validateDate = new ValidatorRegexString(requestPromotion.getString(), Constants.DATE_REGEX);
        if(validateDate.isCheck()){
            System.out.println("Validate input follow date regex successfully");
            return true;
        } else {
            System.out.println("Input date now follow regex dd/MM/yyyy, please try again");
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
