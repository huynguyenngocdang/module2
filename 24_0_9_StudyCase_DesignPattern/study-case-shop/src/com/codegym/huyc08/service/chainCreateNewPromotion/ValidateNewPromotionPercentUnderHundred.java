package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDoubleUnderHundred;

import java.util.Scanner;

public class ValidateNewPromotionPercentUnderHundred implements HandlerNewPromotion {
    private final Scanner SCANNER;
    private HandlerNewPromotion next;

    public ValidateNewPromotionPercentUnderHundred(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        Validator validateUnderHundred = new ValidatorDoubleUnderHundred(requestNewPromotion.getPromotionPercent());
        if(validateUnderHundred.isCheck()) {
            System.out.println("Check new percent under 100 successfully");
            return true;
        } else {
            System.out.println("New percent amount can't not be over 100");
            return false;
        }
    }

    @Override
    public void handle(RequestNewPromotion requestNewPromotion) {
        if (!doHandle(requestNewPromotion)) {
            return;
        }
        if(next!=null){
            next.handle(requestNewPromotion);
        }
    }
}
