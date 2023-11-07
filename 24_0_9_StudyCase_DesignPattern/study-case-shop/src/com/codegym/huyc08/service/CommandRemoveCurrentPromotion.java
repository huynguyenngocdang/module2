package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.MenuAdmin;
import com.codegym.huyc08.menu.Navigator;

public class CommandRemoveCurrentPromotion extends Subject implements Command{
    @Override
    public void execute() {
        Command currentPromotionInformation = new CommandGetCurrentPromotionInformation();
        currentPromotionInformation.execute();

        Confirm confirm = new Confirmation("remove this promotion");
        if(confirm.isConfirm()) {
            Observer observer = SingletonListPromotion.getInstance();
            addObserver(observer);
            SingletonListPromotion.getInstance().getPromotions().remove(SingletonCurrentPromotion.getInstance().getCurrentPromotion());
            notifyObserver();
            removeObserver(observer);
            Navigator navigator = new MenuAdmin();
            navigator.navigate();
        }
    }
}
