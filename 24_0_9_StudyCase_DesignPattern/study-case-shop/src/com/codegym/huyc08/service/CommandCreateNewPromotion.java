package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainCreateNewPromotion.CreateNewPromotion;
import com.codegym.huyc08.service.chainCreateNewPromotion.InputNewPromotionAmount;
import com.codegym.huyc08.service.chainCreateNewPromotion.InputNewPromotionCode;
import com.codegym.huyc08.service.chainCreateNewPromotion.InputNewPromotionEndDate;
import com.codegym.huyc08.service.chainCreateNewPromotion.InputNewPromotionPercent;
import com.codegym.huyc08.service.chainCreateNewPromotion.InputNewPromotionStartDate;
import com.codegym.huyc08.service.chainCreateNewPromotion.RequestANewPromotion;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionAmountNotNegative;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionCodeExistByCode;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionCodeFollowRegex;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionEndDateAfterStartDate;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionEndDateAfterToday;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionEndDateFollowRegex;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionEndDateIsDate;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionPercentNotNegative;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionPercentUnderHundred;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionStartDateFollowRegex;
import com.codegym.huyc08.service.chainCreateNewPromotion.ValidateNewPromotionStartDateIsDate;

import java.util.Scanner;

public class CommandCreateNewPromotion implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {

        //Validate promotion code regex - validate code exist - validate promotion end date - validate promotion amount - validate promotion percent
        HandlerNewPromotion createNewPromotion = new CreateNewPromotion(null);

        HandlerNewPromotion validatePromotionPercentUnderHundred = new ValidateNewPromotionPercentUnderHundred(createNewPromotion);
        HandlerNewPromotion validatePromotionPercentNotNegative = new ValidateNewPromotionPercentNotNegative(validatePromotionPercentUnderHundred);
        HandlerNewPromotion inputPromotionPercent = new InputNewPromotionPercent(validatePromotionPercentNotNegative);

        HandlerNewPromotion validatePromotionAmountNotNegative = new ValidateNewPromotionAmountNotNegative(inputPromotionPercent);
        HandlerNewPromotion inputPromotionAmount = new InputNewPromotionAmount(validatePromotionAmountNotNegative);

        HandlerNewPromotion validateEndDateAfterStartDate = new ValidateNewPromotionEndDateAfterStartDate(inputPromotionAmount);
        HandlerNewPromotion validateEndDateAfterToday = new ValidateNewPromotionEndDateAfterToday(validateEndDateAfterStartDate);
        HandlerNewPromotion validateEndDateIsDate = new ValidateNewPromotionEndDateIsDate(validateEndDateAfterToday);
        HandlerNewPromotion validateEndDateRegex = new ValidateNewPromotionEndDateFollowRegex(validateEndDateIsDate);
        HandlerNewPromotion inputPromotionEndDate = new InputNewPromotionEndDate(validateEndDateRegex);

        HandlerNewPromotion validateStartDateIsDate = new ValidateNewPromotionStartDateIsDate(inputPromotionEndDate);
        HandlerNewPromotion validateStartDateRegex = new ValidateNewPromotionStartDateFollowRegex(validateStartDateIsDate);
        HandlerNewPromotion inputPromotionStartDate = new InputNewPromotionStartDate(validateStartDateRegex);

        HandlerNewPromotion validateCodeRegex = new ValidateNewPromotionCodeFollowRegex(inputPromotionStartDate);
        HandlerNewPromotion validateCodeExist = new ValidateNewPromotionCodeExistByCode(validateCodeRegex);
        HandlerNewPromotion inputPromotionCode = new InputNewPromotionCode(validateCodeExist);
        inputPromotionCode.handle(new RequestANewPromotion());
    }
}
