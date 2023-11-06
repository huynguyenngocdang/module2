package com.codegym.huyc08.service.chainChangePromotionCode;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegexString;

public class ValidatePromotionFollowRegex implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidatePromotionFollowRegex(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        Validator validateRegex = new ValidatorRegexString(requestPromotion.getString(), Constants.PROMOTION_REGEX);
        if (validateRegex.isCheck()){
            System.out.println("Check new promotion code regex successfully");
            return true;
        } else {
            System.out.println("New promotion code must start with KM and at least 2 non-special character");
            return false;
        }
    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
            if(!doHandle(requestPromotion)){
                return;
            }
            if(next!= null) {
                next.handle(requestPromotion);
            }
    }
}
