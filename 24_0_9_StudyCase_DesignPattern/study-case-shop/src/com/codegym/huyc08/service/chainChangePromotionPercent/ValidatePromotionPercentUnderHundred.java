package com.codegym.huyc08.service.chainChangePromotionPercent;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDoubleUnderHundred;

public class ValidatePromotionPercentUnderHundred implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidatePromotionPercentUnderHundred(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        Validator validateUnderHundred = new ValidatorDoubleUnderHundred(requestPromotion.getDoubleValue());
        if(validateUnderHundred.isCheck()) {
            System.out.println("Check new percent under 100 successfully");
            return true;
        } else {
            System.out.println("New percent amount can't not be over 100");
        return false;
        }
    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
        if(!doHandle(requestPromotion)){
            return;
        }
        if(next != null){
            next.handle(requestPromotion);
        }
    }
}
