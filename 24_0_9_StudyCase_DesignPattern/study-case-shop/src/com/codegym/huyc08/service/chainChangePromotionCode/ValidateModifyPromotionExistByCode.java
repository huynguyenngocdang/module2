package com.codegym.huyc08.service.chainChangePromotionCode;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorPromotionExistByCode;

public class ValidateModifyPromotionExistByCode implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateModifyPromotionExistByCode(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        Validator validatePromotionExist = new ValidatorPromotionExistByCode(requestModifyPromotion.getPromotionCode());
        if(!validatePromotionExist.isCheck()){
            System.out.println("Check promotion does not exist in database successfully");
            return true;
        } else {
            System.out.println("Promotion code already exist, please choose other code");
            return false;
        }
    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next!=null) {
            next.handle(requestModifyPromotion);
        }
    }
}
