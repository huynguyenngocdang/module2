package com.codegym.huyc08.service.chainChangePromotionStartDate;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorRegexString;

public class ValidateStartDateFollowRegex implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateStartDateFollowRegex(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        Validator validateDate = new ValidatorRegexString(requestModifyPromotion.getPromotionDateStart(), AppConstant.DATE_REGEX);
        if(validateDate.isCheck()){
            System.out.println("Validate input follow date regex successfully");
            return true;
        } else {
            System.out.println("Input date now follow regex dd/MM/yyyy, please try again");
            return false;
        }

    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if (!doHandle(requestModifyPromotion)) {
            return;
        }
        if(next!= null) {
            next.handle(requestModifyPromotion);
        }

    }
}
