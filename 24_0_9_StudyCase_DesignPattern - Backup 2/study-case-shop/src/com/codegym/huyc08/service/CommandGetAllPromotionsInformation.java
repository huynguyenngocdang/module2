package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Promotion;
import com.codegym.huyc08.menu.Command;

public class CommandGetAllPromotionsInformation implements Command {
    @Override
    public void execute() {
        for (Promotion promotion : SingletonListPromotion.getInstance().getPromotions()
                ) {
            System.out.println(promotion.toString());
        }
    }
}
