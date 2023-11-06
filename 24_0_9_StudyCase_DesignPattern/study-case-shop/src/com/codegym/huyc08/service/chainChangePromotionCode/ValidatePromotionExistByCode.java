package com.codegym.huyc08.service.chainChangePromotionCode;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorPromotionExistByCode;

public class ValidatePromotionExistByCode implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidatePromotionExistByCode(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        Validator validatePromotionExist = new ValidatorPromotionExistByCode(requestPromotion.getString());
        if(!validatePromotionExist.isCheck()){
            System.out.println("Check promotion does not exist in database successfully");
            return true;
        } else {
            System.out.println("Promotion code already exist, please choose other code");
            return false;
        }
    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
        if(!doHandle(requestPromotion)){
            return;
        }
        if(next!=null) {
            next.handle(requestPromotion);
        }
    }
}
