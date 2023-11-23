package com.codegym.huyc08.service.chainChangePromotionCode;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegexString;

public class ValidateModifyPromotionFollowRegex implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateModifyPromotionFollowRegex(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        Validator validateRegex = new ValidatorRegexString(requestModifyPromotion.getPromotionCode(), AppConstant.PROMOTION_REGEX);
        if (validateRegex.isCheck()){
            System.out.println("Check new promotion code regex successfully");
            return true;
        } else {
            System.out.println("New promotion code must start with KM and at least 2 non-special character");
            return false;
        }
    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
            if(!doHandle(requestModifyPromotion)){
                return;
            }
            if(next!= null) {
                next.handle(requestModifyPromotion);
            }
    }
}
