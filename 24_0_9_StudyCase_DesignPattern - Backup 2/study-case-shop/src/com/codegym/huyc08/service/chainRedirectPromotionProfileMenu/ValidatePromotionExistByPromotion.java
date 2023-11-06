package com.codegym.huyc08.service.chainRedirectPromotionProfileMenu;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorPromotionExistById;

public class ValidatePromotionExistByPromotion implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidatePromotionExistByPromotion(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        int promotionId = requestPromotion.getId();
        Validator validator = new ValidatorPromotionExistById(promotionId);
        if(validator.isCheck()){
            System.out.println("Check promotion exist successfully");
            return true;
        } else {
            System.out.println("Promotion does not exist in database");
            return false;
        }

    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
        if(!doHandle(requestPromotion)){
            return;
        }
        if(next != null) {
            next.handle(requestPromotion);
        }
    }
}
