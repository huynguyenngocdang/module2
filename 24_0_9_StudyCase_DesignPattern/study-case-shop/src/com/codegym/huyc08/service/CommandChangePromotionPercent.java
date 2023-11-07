package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainChangePromotionPercent.ChangeModifyPromotionPercent;
import com.codegym.huyc08.service.chainChangePromotionPercent.RequestChangeModifyPromotionPercent;
import com.codegym.huyc08.service.chainChangePromotionPercent.ValidateModifyPromotionPercentNotNegative;
import com.codegym.huyc08.service.chainChangePromotionPercent.ValidateModifyPromotionPercentUnderHundred;

import java.util.Scanner;

public class CommandChangePromotionPercent implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input new percent (0-100)");
        double newPercent = SCANNER.nextDouble();

        //validate not negative - validate under 100 - change new amount;
        HandlerModifyPromotion changePromotionPercent = new ChangeModifyPromotionPercent(null);
        HandlerModifyPromotion validatePromotionPercentUnderHundred = new ValidateModifyPromotionPercentUnderHundred(changePromotionPercent);
        HandlerModifyPromotion validatePromotionPercentNotNegative = new ValidateModifyPromotionPercentNotNegative(validatePromotionPercentUnderHundred);
        validatePromotionPercentNotNegative.handle(new RequestChangeModifyPromotionPercent(newPercent));

    }
}
