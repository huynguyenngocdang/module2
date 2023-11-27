package com.codegym.huyc08.service.chainRedirectPromotionProfileMenu;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorPromotionExistById;

public class ValidatePromotionExistByModifyPromotion implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidatePromotionExistByModifyPromotion(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        int promotionId = requestModifyPromotion.getPromotionId();
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
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next != null) {
            next.handle(requestModifyPromotion);
        }
    }
}
