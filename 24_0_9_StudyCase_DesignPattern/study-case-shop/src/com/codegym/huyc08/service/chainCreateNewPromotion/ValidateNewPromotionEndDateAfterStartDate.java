package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDateBeforeDate;

import java.util.Scanner;

public class ValidateNewPromotionEndDateAfterStartDate implements HandlerNewPromotion {
    private final Scanner SCANNER;
    private HandlerNewPromotion next;

    public ValidateNewPromotionEndDateAfterStartDate(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        String newEndDate = requestNewPromotion.getPromotionDateEnd();
        String currentStartDate = requestNewPromotion.getPromotionDateStart();
        Validator validateStartDateBeforeEndDate = new ValidatorDateBeforeDate(currentStartDate, newEndDate);
        if(validateStartDateBeforeEndDate.isCheck()){
            System.out.println("Check end date after start date successfully");
            return true;
        } else {
            System.out.println("Can't have end date before start date");
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
