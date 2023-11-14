package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainChangePromotionCode.ChangeModifyPromotionCode;
import com.codegym.huyc08.service.chainChangePromotionCode.RequestChangeModifyPromotionCode;
import com.codegym.huyc08.service.chainChangePromotionCode.ValidateModifyPromotionExistByCode;
import com.codegym.huyc08.service.chainChangePromotionCode.ValidateModifyPromotionFollowRegex;

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
        HandlerModifyPromotion changeCode = new ChangeModifyPromotionCode(null);
        HandlerModifyPromotion validatePromotionCodeExist = new ValidateModifyPromotionExistByCode(changeCode);
        HandlerModifyPromotion validatePromotionCodeFollowRegex = new ValidateModifyPromotionFollowRegex(validatePromotionCodeExist);
        validatePromotionCodeFollowRegex.handle(new RequestChangeModifyPromotionCode(currentPromotionId, newCode));

    }
}
