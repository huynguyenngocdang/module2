package com.codegym.huyc08.service.chainCreateNewUser;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.UserFactory;
import com.codegym.huyc08.entity.UserType;
import com.codegym.huyc08.service.GenerateId;
import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.Subject;

public class CreateNewUser extends Subject implements HandlerUserInformation {

    private HandlerUserInformation nextHandlerUserInformation;


    public CreateNewUser(HandlerUserInformation nextHandlerUserInformation) {
        this.nextHandlerUserInformation = nextHandlerUserInformation;

    }
    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        var userFactory = new UserFactory();
        GenerateId generateId = SingletonListNormalUser.getInstance();
        int newId = generateId.getNewId();
        var newNormalUser = userFactory.createUser(newId, requestUserInformation.getUsername(), requestUserInformation.getPassword(), 0, UserType.NORMAL, true);
        Observer observer = SingletonListNormalUser.getInstance();
        addObserver(observer);
        SingletonListNormalUser.getInstance().addUser((NormalUser) newNormalUser);
        System.out.println("Create new user successful");
        notifyObserver();
        removeObserver(observer);
        return true;
    }

    @Override
    public void handle(RequestUserInformation requestUserInformation) {
        if(!doHandle(requestUserInformation)) {
            return;
        }
        if (nextHandlerUserInformation != null) {
            nextHandlerUserInformation.handle(requestUserInformation);
        }
    }
}
