package com.codegym.huyc08.service.chainForgotPassword;

import com.codegym.huyc08.entity.MessageFactory;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.SingletonListMessage;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.Subject;

import java.util.List;

public class messageAdminForgotPassword extends Subject implements HandlerUserInformation {
    private HandlerUserInformation next;

    public messageAdminForgotPassword(HandlerUserInformation next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        try {
            MessageFactory factory = new MessageFactory();
            String username = requestUserInformation.getUsername();
            NormalUser user = SingletonListNormalUser.getInstance().getCurrentUser(username);
            int userId = user.getUserId();
            Observer observer = SingletonListMessage.getInstance();
            addObserver(observer);
            SingletonListMessage.getInstance().getMessages().add(factory.createMessage(user.getUserId(), -1,"userid " + userId + " with username " + username + " has forgot password"));
            notifyObserver();
            removeObserver(observer);
            return true;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public void handle(RequestUserInformation requestUserInformation) {
        if(!doHandle(requestUserInformation)){
            return;
        }
        if(next != null) {
            next.handle(requestUserInformation);
        }
    }
}
