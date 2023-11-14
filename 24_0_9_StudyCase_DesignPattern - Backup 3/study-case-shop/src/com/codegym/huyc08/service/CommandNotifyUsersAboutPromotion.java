package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Message;
import com.codegym.huyc08.entity.MessageFactory;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.Promotion;

public class CommandNotifyUsersAboutPromotion extends Subject implements Command{
    private int adminId;
    private Promotion thisPromotion;

    public CommandNotifyUsersAboutPromotion(int adminId, Promotion thisPromotion) {
        this.adminId = adminId;
        this.thisPromotion = thisPromotion;
    }

    @Override
    public void execute() {
        Confirm confirm = new Confirmation("to notify all users about this promotion " + thisPromotion.getPromotionCode() + " with start date " + thisPromotion.getPromotionDateStart() + " and end date" + thisPromotion.getPromotionDateEnd());
        if(confirm.isConfirm()) {
            MessageFactory factory = new MessageFactory();
            Observer observer = SingletonListMessage.getInstance();
            addObserver(observer);
            for (NormalUser normalUser : SingletonListNormalUser.getInstance().getUsers()
            ) {
                Message newMessage = factory.createMessage(adminId, normalUser.getUserId(), "Promotion " +thisPromotion.getPromotionCode() + " is available to use from " +thisPromotion.getPromotionDateStart() + " until " + thisPromotion.getPromotionDateEnd() );
                SingletonListMessage.getInstance().getMessages().add(newMessage);
            }
            notifyObserver();
            removeObserver(observer);
        }
    }
}
