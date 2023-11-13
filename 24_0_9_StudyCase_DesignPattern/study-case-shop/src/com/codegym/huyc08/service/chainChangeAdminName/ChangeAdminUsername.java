package com.codegym.huyc08.service.chainChangeAdminName;

import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.SingletonCurrentAdmin;
import com.codegym.huyc08.service.SingletonListAdmin;
import com.codegym.huyc08.service.Subject;

public class ChangeAdminUsername extends Subject implements HandlerUserInformation {
    private HandlerUserInformation next;

    public ChangeAdminUsername(HandlerUserInformation next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        try {
            Observer observer = SingletonListAdmin.getInstance();
            addObserver(observer);
            String username = requestUserInformation.getUsername();
            SingletonCurrentAdmin.getInstance().changeAdminUsername(username);
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
        if (next != null) {
            next.handle(requestUserInformation);
        }
    }
}
