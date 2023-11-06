package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainChangePromotionCode.ChangePromotionCode;
import com.codegym.huyc08.service.chainChangePromotionCode.RequestChangePromotionCode;
import com.codegym.huyc08.service.chainChangePromotionCode.ValidatePromotionExistByCode;
import com.codegym.huyc08.service.chainChangePromotionCode.ValidatePromotionFollowRegex;

import java.util.Scanner;

public class CommandChangePromotionCode implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Changing promotion Code");
        System.out.println("Input new promotion code");
        String newCode = SCANNER.next();
        int currentPromotionId = SingletonCurrentPromotion.getInstance().getCurrentPromotion().getPromotionId();
        //validate promotion code regex, validate promotion code exist, change promotion code
        HandlerPromotion changeCode = new ChangePromotionCode(null);
        HandlerPromotion validatePromotionCodeExist = new ValidatePromotionExistByCode(changeCode);
        HandlerPromotion validatePromotionCodeFollowRegex = new ValidatePromotionFollowRegex(validatePromotionCodeExist);
        validatePromotionCodeFollowRegex.handle(new RequestChangePromotionCode(currentPromotionId, newCode));

    }
}
