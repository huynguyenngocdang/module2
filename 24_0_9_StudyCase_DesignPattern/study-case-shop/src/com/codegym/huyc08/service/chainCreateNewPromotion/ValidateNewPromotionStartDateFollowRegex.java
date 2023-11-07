package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegexString;

import java.util.Scanner;

public class ValidateNewPromotionStartDateFollowRegex implements HandlerNewPromotion {
    private final Scanner SCANNER;
    private HandlerNewPromotion next;

    public ValidateNewPromotionStartDateFollowRegex(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        Validator validateDate = new ValidatorRegexString(requestNewPromotion.getPromotionDateStart(), Constants.DATE_REGEX);
        if(validateDate.isCheck()){
            System.out.println("Validate input follow date regex successfully");
            return true;
        } else {
            System.out.println("Input date now follow regex dd/MM/yyyy, please try again");
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
