package com.codegym.huyc08.service.chainChangePromotionPercent;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDoubleUnderHundred;

public class ValidateModifyPromotionPercentUnderHundred implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateModifyPromotionPercentUnderHundred(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        Validator validateUnderHundred = new ValidatorDoubleUnderHundred(requestModifyPromotion.getPromotionPercent());
        if(validateUnderHundred.isCheck()) {
            System.out.println("Check new percent under 100 successfully");
            return true;
        } else {
            System.out.println("New percent amount can't not be over 100");
        return false;
        }
    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next != null){
            next.handle(requestModifyPromotion);
        }
    }
}
