package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.service.chainChangePromotionAmount.ChangePromotionAmount;
import com.codegym.huyc08.service.chainChangePromotionPercent.ChangePromotionPercent;
import com.codegym.huyc08.service.chainChangePromotionPercent.RequestChangePromotionPercent;
import com.codegym.huyc08.service.chainChangePromotionPercent.ValidatePromotionPercentNotNegative;
import com.codegym.huyc08.service.chainChangePromotionPercent.ValidatePromotionPercentUnderHundred;

import java.util.Scanner;

public class CommandChangePromotionPercent implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input new percent (0-100)");
        double newPercent = SCANNER.nextDouble();

        //validate not negative - validate under 100 - change new amount;
        HandlerPromotion changePromotionPercent = new ChangePromotionPercent(null);
        HandlerPromotion validatePromotionPercentUnderHundred = new ValidatePromotionPercentUnderHundred(changePromotionPercent);
        HandlerPromotion validatePromotionPercentNotNegative = new ValidatePromotionPercentNotNegative(validatePromotionPercentUnderHundred);
        validatePromotionPercentNotNegative.handle(new RequestChangePromotionPercent(newPercent));

    }
}
