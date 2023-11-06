package com.codegym.huyc08.service.chainChangeUsername;

import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.Subject;

public class ChangeUserUsername extends Subject implements Handler {
    private Handler next;

    public ChangeUserUsername(Handler next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(Request request) {
        try {
            Observer currentUser = SingletonCurrentUser.getInstance();
            addObserver(currentUser);
            SingletonCurrentUser.getInstance().changeUsername(request.getUsername());
            notifyObserver();
            removeObserver(currentUser);
            return true;
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public void handle(Request request) {
        if (!doHandle(request)) {
            return;
        }
        if (next != null) {
            next.handle(request);
        }
    }
}
