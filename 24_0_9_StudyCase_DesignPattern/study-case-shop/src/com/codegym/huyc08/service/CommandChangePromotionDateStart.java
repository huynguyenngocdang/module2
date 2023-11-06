package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.service.chainChangePromotionStartDate.ChangePromotionStartDate;
import com.codegym.huyc08.service.chainChangePromotionStartDate.RequestChangePromotionStartDate;
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
        HandlerPromotion changeStartDate = new ChangePromotionStartDate(null);
        HandlerPromotion validateStartDateBeforeEndDate = new ValidateStartDateBeforeEndDate(changeStartDate);
        HandlerPromotion validateStartDateIsDate = new ValidateStartDateIsDate(validateStartDateBeforeEndDate);
        HandlerPromotion validateStartDateFollowRegex = new ValidateStartDateFollowRegex(validateStartDateIsDate);
        validateStartDateFollowRegex.handle(new RequestChangePromotionStartDate(newStartDate));
    }
}
