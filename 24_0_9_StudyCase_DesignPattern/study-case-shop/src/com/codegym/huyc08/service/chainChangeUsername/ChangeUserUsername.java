package com.codegym.huyc08.service.chainChangeUsername;

import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.Subject;

public class ChangeUserUsername extends Subject implements HandlerUserInformation {
    private HandlerUserInformation next;

    public ChangeUserUsername(HandlerUserInformation next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        try {
            Observer currentUser = SingletonCurrentUser.getInstance();
            addObserver(currentUser);
            SingletonCurrentUser.getInstance().changeUsername(requestUserInformation.getUsername());
            notifyObserver();
            removeObserver(currentUser);
            return true;
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public void handle(RequestUserInformation requestUserInformation) {
        if (!doHandle(requestUserInformation)) {
            return;
        }
        if (next != null) {
            next.handle(requestUserInformation);
        }
    }
}
