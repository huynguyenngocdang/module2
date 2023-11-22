package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainChangePromotionEndDate.ChangeModifyPromotionEndDate;
import com.codegym.huyc08.service.chainChangePromotionEndDate.RequestChangeModifyPromotionEndDate;
import com.codegym.huyc08.service.chainChangePromotionEndDate.ValidateEndDateAfterStartDate;
import com.codegym.huyc08.service.chainChangePromotionEndDate.ValidateEndDateAfterToday;
import com.codegym.huyc08.service.chainChangePromotionEndDate.ValidateEndDateFollowRegex;
import com.codegym.huyc08.service.chainChangePromotionEndDate.ValidateEndDateIsDate;

import java.util.Scanner;

public class CommandChangePromotionDateEnd implements Command {
    private Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        System.out.println("Input new end date (dd/MM/yyyy)");
        String newEndDate = SCANNER.next();
        //validate follow regex -validate date is date - validate end date after start date - validate end date after today -  change start date
        HandlerModifyPromotion changeEndDate = new ChangeModifyPromotionEndDate(null);
        HandlerModifyPromotion validateEndDateAfterToday = new ValidateEndDateAfterToday(changeEndDate);
        HandlerModifyPromotion validateEndDateAfterStartDate = new ValidateEndDateAfterStartDate(validateEndDateAfterToday);
        HandlerModifyPromotion validateEndDateIsDate = new ValidateEndDateIsDate(validateEndDateAfterStartDate);
        HandlerModifyPromotion validateEndDateFollowRegex = new ValidateEndDateFollowRegex(validateEndDateIsDate);
        validateEndDateFollowRegex.handle(new RequestChangeModifyPromotionEndDate(newEndDate));

    }
}
