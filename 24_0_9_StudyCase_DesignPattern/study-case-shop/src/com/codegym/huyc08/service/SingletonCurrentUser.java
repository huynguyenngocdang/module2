package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.entity.User;

import java.util.ArrayList;
import java.util.List;

public class SingletonCurrentUser implements Observer {
    private List<NormalUser> users;

    private NormalUser currentUser;
    private static SingletonCurrentUser instance;
    private final MyFileHandler fileHandler;

    private SingletonCurrentUser() {
        fileHandler = new JsonFileHandler();
        users = SingletonListNormalUser.getInstance().getUsers();

    }
    public static SingletonCurrentUser getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentUser();
        }
        return instance;
    }
    public NormalUser getCurrentUser(){
        return currentUser;
    }
    public void setCurrentUser(String username, String password) {
        for (NormalUser user: users
             ) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return;
            }
        }
        System.out.println("Can't set current user");
    }
    public void setCurrentUser(int id) {
        for (NormalUser user: users
        ) {
            if (user.getUserId() == id) {
                currentUser = user;
                return;
            }
        }
        System.out.println("Can't set current user");
    }


    public void changeUsername(String newUsername) {
        currentUser.setUsername(newUsername);
    }
    public void changeUserPassword(String newPassword) {
        currentUser.setPassword(newPassword);
    }
    public void changeUserBalance(double newAmount) {
        currentUser.setWalletBalance(currentUser.getWalletBalance() + newAmount);
    }
    public boolean getCurrentUserStatus(){
        return currentUser.isActive();
    }
    public void changeUserStatus() {
        currentUser.setActive(!currentUser.isActive());
    }

    @Override
    public void update() {
//        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
        SingletonListNormalUser.getInstance().update();
        System.out.println("Current user data updated successfully");
    }
}
