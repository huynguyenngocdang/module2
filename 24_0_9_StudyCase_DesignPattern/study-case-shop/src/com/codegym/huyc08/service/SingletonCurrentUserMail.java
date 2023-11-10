package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;

public class SingletonCurrentUserMail implements Observer {
    private NormalUser currentUser;
    private static SingletonCurrentUserMail instance;
    private SingletonCurrentUserMail() {
        currentUser = SingletonCurrentUser.getInstance().getCurrentUser();
    }
    public static SingletonCurrentUserMail getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentUserMail();
        }
        return instance;
    }
    private void mailToAddress() {
        System.out.println("Mailing item to " + currentUser.getAddress());
    }

    @Override
    public void update() {
        mailToAddress();
    }
}
