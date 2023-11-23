package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorPromotionExistByCode;

import java.util.Scanner;

public class ValidateNewPromotionCodeExistByCode implements HandlerNewPromotion {
    private final Scanner SCANNER;
    private HandlerNewPromotion next;

    public ValidateNewPromotionCodeExistByCode(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        Validator validatePromotionExist = new ValidatorPromotionExistByCode(requestNewPromotion.getPromotionCode());
        if(!validatePromotionExist.isCheck()){
            System.out.println("Check promotion does not exist in database successfully");
            return true;
        } else {
            System.out.println("Promotion code already exist, please choose other code");
            return false;
        }
    }

    @Override
    public void handle(RequestNewPromotion requestNewPromotion) {
        if(!doHandle(requestNewPromotion)) {
            return;
        }
        if(next!=null){
            next.handle(requestNewPromotion);
        }
    }
}
