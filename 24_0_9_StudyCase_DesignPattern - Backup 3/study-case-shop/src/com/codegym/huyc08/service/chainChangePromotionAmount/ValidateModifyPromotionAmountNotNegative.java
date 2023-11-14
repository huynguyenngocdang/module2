package com.codegym.huyc08.service.chainChangePromotionAmount;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDoubleNotNegative;

public class ValidateModifyPromotionAmountNotNegative implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateModifyPromotionAmountNotNegative(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        Validator validateNotNegative = new ValidatorDoubleNotNegative(requestModifyPromotion.getPromotionAmount());
        if(validateNotNegative.isCheck()) {
            System.out.println("Check new amount not a negative number");
            return true;
        } else {
            System.out.println("You can't enter a negative value");
            return false;
        }

    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next!=null){
            next.handle(requestModifyPromotion);
        }
    }
}
