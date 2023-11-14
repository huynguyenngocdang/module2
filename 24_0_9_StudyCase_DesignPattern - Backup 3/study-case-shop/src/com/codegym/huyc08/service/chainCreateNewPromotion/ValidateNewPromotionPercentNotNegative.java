package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDoubleNotNegative;

import java.util.Scanner;

public class ValidateNewPromotionPercentNotNegative implements HandlerNewPromotion {
    private final Scanner SCANNER;
    private HandlerNewPromotion next;

    public ValidateNewPromotionPercentNotNegative(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        Validator validateNotNegative = new ValidatorDoubleNotNegative(requestNewPromotion.getPromotionPercent());
        if(validateNotNegative.isCheck()) {
            System.out.println("Check new percent not a negative number successfully");
            return true;
        } else {
            System.out.println("You can't enter a negative value");
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
