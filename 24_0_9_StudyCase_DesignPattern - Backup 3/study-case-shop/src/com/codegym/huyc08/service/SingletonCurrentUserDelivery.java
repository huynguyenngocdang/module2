package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;

public class SingletonCurrentUserDelivery implements Observer {
    private NormalUser currentUser;
    private static SingletonCurrentUserDelivery instance;
    private SingletonCurrentUserDelivery() {
        currentUser = SingletonCurrentUser.getInstance().getCurrentUser();
    }
    public static SingletonCurrentUserDelivery getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentUserDelivery();
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
