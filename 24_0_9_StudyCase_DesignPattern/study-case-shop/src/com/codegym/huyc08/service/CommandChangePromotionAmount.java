package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.service.chainChangePromotionAmount.ChangePromotionAmount;
import com.codegym.huyc08.service.chainChangePromotionAmount.RequestChangePromotionAmount;
import com.codegym.huyc08.service.chainChangePromotionAmount.ValidatePromotionAmountNotNegative;

import java.util.Scanner;

public class CommandChangePromotionAmount implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input new amount (>= 0)");
        double newAmount = SCANNER.nextDouble();

        //validate not negative - change new amount;
        HandlerPromotion changePromotionAmount = new ChangePromotionAmount(null);
        HandlerPromotion validatePromotionAmountNotNegative = new ValidatePromotionAmountNotNegative(changePromotionAmount);
        validatePromotionAmountNotNegative.handle(new RequestChangePromotionAmount(newAmount));
    }
}
