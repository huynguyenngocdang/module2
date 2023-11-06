package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainChangePromotionEndDate.ChangePromotionEndDate;
import com.codegym.huyc08.service.chainChangePromotionEndDate.RequestChangePromotionEndDate;
import com.codegym.huyc08.service.chainChangePromotionEndDate.ValidateEndDateAfterStartDate;
import com.codegym.huyc08.service.chainChangePromotionEndDate.ValidateEndDateAfterToday;
import com.codegym.huyc08.service.chainChangePromotionEndDate.ValidateEndDateFollowRegex;
import com.codegym.huyc08.service.chainChangePromotionEndDate.ValidateEndDateIsDate;

import java.util.Scanner;

public class CommandChangePromotionDateEnd implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input new end date (dd/MM/yyyy)");
        String newEndDate = SCANNER.next();
        //validate follow regex -validate date is date - validate end date after start date - validate end date after today -  change start date
        HandlerPromotion changeEndDate = new ChangePromotionEndDate(null);
        HandlerPromotion validateEndDateAfterToday = new ValidateEndDateAfterToday(changeEndDate);
        HandlerPromotion validateEndDateAfterStartDate = new ValidateEndDateAfterStartDate(validateEndDateAfterToday);
        HandlerPromotion validateEndDateIsDate = new ValidateEndDateIsDate(validateEndDateAfterStartDate);
        HandlerPromotion validateEndDateFollowRegex = new ValidateEndDateFollowRegex(validateEndDateIsDate);
        validateEndDateFollowRegex.handle(new RequestChangePromotionEndDate(newEndDate));

    }
}
