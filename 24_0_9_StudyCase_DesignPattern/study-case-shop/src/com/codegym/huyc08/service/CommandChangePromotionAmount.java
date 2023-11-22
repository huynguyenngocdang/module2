package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainChangePromotionAmount.ChangeModifyPromotionAmount;
import com.codegym.huyc08.service.chainChangePromotionAmount.RequestChangeModifyPromotionAmount;
import com.codegym.huyc08.service.chainChangePromotionAmount.ValidateModifyPromotionAmountNotNegative;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandChangePromotionAmount implements Command {
    private  Scanner SCANNER;
    @Override
    public void execute() {
        try {
            SCANNER = new Scanner(System.in);
            System.out.println("Input new amount (>= 0)");
            double newAmount = SCANNER.nextDouble();

            //validate not negative - change new amount;
            HandlerModifyPromotion changePromotionAmount = new ChangeModifyPromotionAmount(null);
            HandlerModifyPromotion validatePromotionAmountNotNegative = new ValidateModifyPromotionAmountNotNegative(changePromotionAmount);
            validatePromotionAmountNotNegative.handle(new RequestChangeModifyPromotionAmount(newAmount));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
        }

    }
}
