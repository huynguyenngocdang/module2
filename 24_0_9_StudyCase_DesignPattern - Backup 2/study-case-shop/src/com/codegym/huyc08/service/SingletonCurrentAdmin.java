package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Admin;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingletonCurrentAdmin implements Observer{
    private List<Admin> admins;
    private Admin currentAdmin;
    private final Type ADMINTYPE = new TypeToken<ArrayList<Admin>>(){}.getType();
    private static SingletonCurrentAdmin instance;
    private MyFileHandler fileHandler;

    private SingletonCurrentAdmin() {
        fileHandler = new JsonFileHandler();
//        this.admins = (List<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, ADMINTYPE);
        this.admins = SingletonListAdmin.getInstance().getAdmins();
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
        for (Admin admin: admins
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

    @Override
    public void update() {
//        fileHandler.saveToFile(Constants.ADMIN_FILE_PATH, admins);
        SingletonListAdmin.getInstance().update();
        System.out.println("Admin file updated successfully");
    }
}
