package com.codegym.huyc08.service;

public class CommandGetCurrentPromotionInformation implements Command {
    @Override
    public void execute() {
        SingletonCurrentPromotion.getInstance().getCurrentPromotionInformation();
    }
}
