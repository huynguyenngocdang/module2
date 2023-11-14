package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainRemoveExpirePromotion.DisplayAllExpiredModifyPromotion;
import com.codegym.huyc08.service.chainRemoveExpirePromotion.RemoveAllExpiredModifyPromotion;
import com.codegym.huyc08.service.chainRemoveExpirePromotion.RequestRemoveExpiredModifyPromotion;

public class CommandRemoveAllExpiredPromotion implements Command {
    @Override
    public void execute() {
        //get all expired promotion + confirm remove - remove promotion
        HandlerModifyPromotion removeExpiredPromotion = new RemoveAllExpiredModifyPromotion(null);
        HandlerModifyPromotion displayAllExpiredPromotion = new DisplayAllExpiredModifyPromotion(removeExpiredPromotion);
        displayAllExpiredPromotion.handle(new RequestRemoveExpiredModifyPromotion());
    }
}
