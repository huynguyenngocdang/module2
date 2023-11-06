package com.codegym.huyc08.service.chainChangePromotionAmount;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDoubleNotNegative;

public class ValidatePromotionAmountNotNegative implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidatePromotionAmountNotNegative(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        Validator validateNotNegative = new ValidatorDoubleNotNegative(requestPromotion.getDoubleValue());
        if(validateNotNegative.isCheck()) {
            System.out.println("Check new amount not a negative number");
            return true;
        } else {
            System.out.println("You can't enter a negative value");
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
