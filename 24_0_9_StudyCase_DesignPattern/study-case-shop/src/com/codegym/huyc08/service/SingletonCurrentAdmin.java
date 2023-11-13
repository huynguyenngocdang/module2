package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Admin;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingletonCurrentAdmin {

    private Admin currentAdmin;

    private static SingletonCurrentAdmin instance;


    private SingletonCurrentAdmin() {


    }
    public static SingletonCurrentAdmin getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentAdmin();
        }
        return instance;
    }
    public Admin getCurrentAdmin() {
        return currentAdmin;
    }
    public void setCurrentAdmin(String username, String password) {
        for (Admin admin: SingletonListAdmin.getInstance().getAdmins()
             ) {
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
                currentAdmin = admin;
                return;
            }
        }
    }
    public void changeAdminUsername(String newUsername) {
        currentAdmin.setUsername(newUsername);
    }
    public void changeAdminPassword(String newPassword) {
        currentAdmin.setPassword(newPassword);
    }

}
