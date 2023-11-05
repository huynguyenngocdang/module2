package com.codegym.huyc08.service.chainChangeAdminName;

import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.SingletonCurrentAdmin;
import com.codegym.huyc08.service.Subject;

public class ChangeAdminUsername extends Subject implements Handler {
    private Handler next;

    public ChangeAdminUsername(Handler next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(Request request) {
        try {
            Observer observer = SingletonCurrentAdmin.getInstance();
            addObserver(observer);
            String username = request.getUsername();
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
    public void handle(Request request) {
        if(!doHandle(request)){
            return;
        }
        if (next != null) {
            next.handle(request);
        }
    }
}
