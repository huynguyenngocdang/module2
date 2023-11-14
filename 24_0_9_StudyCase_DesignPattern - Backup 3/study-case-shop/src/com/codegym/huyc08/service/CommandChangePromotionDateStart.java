package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainChangePromotionStartDate.ChangeModifyPromotionStartDate;
import com.codegym.huyc08.service.chainChangePromotionStartDate.RequestChangeModifyPromotionStartDate;
import com.codegym.huyc08.service.chainChangePromotionStartDate.ValidateStartDateBeforeEndDate;
import com.codegym.huyc08.service.chainChangePromotionStartDate.ValidateStartDateFollowRegex;
import com.codegym.huyc08.service.chainChangePromotionStartDate.ValidateStartDateIsDate;

import java.util.Scanner;

public class CommandChangePromotionDateStart implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input new start date (dd/MM/yyyy)");
        String newStartDate = SCANNER.next();

        //validate follow regex -validate date is date - validate start date before end date - change start date
        HandlerModifyPromotion changeStartDate = new ChangeModifyPromotionStartDate(null);
        HandlerModifyPromotion validateStartDateBeforeEndDate = new ValidateStartDateBeforeEndDate(changeStartDate);
        HandlerModifyPromotion validateStartDateIsDate = new ValidateStartDateIsDate(validateStartDateBeforeEndDate);
        HandlerModifyPromotion validateStartDateFollowRegex = new ValidateStartDateFollowRegex(validateStartDateIsDate);
        validateStartDateFollowRegex.handle(new RequestChangeModifyPromotionStartDate(newStartDate));
    }
}
