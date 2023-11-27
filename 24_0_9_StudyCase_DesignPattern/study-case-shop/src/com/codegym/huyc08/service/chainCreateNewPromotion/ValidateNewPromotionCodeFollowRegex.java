package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorRegexString;

import java.util.Scanner;

public class ValidateNewPromotionCodeFollowRegex implements HandlerNewPromotion {
    private final Scanner SCANNER;
    private HandlerNewPromotion next;

    public ValidateNewPromotionCodeFollowRegex(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        Validator validateRegex = new ValidatorRegexString(requestNewPromotion.getPromotionCode(), AppConstant.PROMOTION_REGEX);
        if (validateRegex.isCheck()){
            System.out.println("Check new promotion code regex successfully");
            return true;
        } else {
            System.out.println("New promotion code must start with KM and at least 2 non-special character");
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
