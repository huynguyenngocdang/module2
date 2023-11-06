package com.codegym.huyc08.service.chainCreateNewUser;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.UserFactory;
import com.codegym.huyc08.entity.UserType;
import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.Subject;

public class CreateNewUser extends Subject implements Handler {

    private Handler nextHandler;


    public CreateNewUser(Handler nextHandler) {
        this.nextHandler = nextHandler;

    }
    @Override
    public boolean doHandle(Request request) {
        var userFactory = new UserFactory();
        var newId = SingletonListNormalUser.getInstance().getNewId();
        var newNormalUser = userFactory.createUser(newId, request.getUsername(), request.getPassword(), 0, UserType.NORMAL, true);
        Observer observer = SingletonListNormalUser.getInstance();
        addObserver(observer);
        SingletonListNormalUser.getInstance().addUser((NormalUser) newNormalUser);
        System.out.println("Create new user successful");
        notifyObserver();
        removeObserver(observer);
        return true;
    }

    @Override
    public void handle(Request request) {
        if(!doHandle(request)) {
            return;
        }
        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }
}
