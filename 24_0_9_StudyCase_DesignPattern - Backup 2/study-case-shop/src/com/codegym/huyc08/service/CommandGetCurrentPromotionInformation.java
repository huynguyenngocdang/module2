package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class CommandGetCurrentPromotionInformation implements Command {
    @Override
    public void execute() {
        SingletonCurrentPromotion.getInstance().getCurrentPromotionInformation();
    }
}
