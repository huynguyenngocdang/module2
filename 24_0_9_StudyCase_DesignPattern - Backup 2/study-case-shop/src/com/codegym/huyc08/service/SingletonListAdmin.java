package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingletonListAdmin implements Observer{
    private List<Admin> admins;
    private MyFileHandler fileHandler;
    private final Type ADMINTYPE = new TypeToken<ArrayList<Admin>>(){}.getType();
    private static SingletonListAdmin instance;

    private SingletonListAdmin() {
        fileHandler = new JsonFileHandler();
        admins = (List<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, ADMINTYPE);
    }
    public static SingletonListAdmin getInstance() {
        if(instance == null) {
            instance = new SingletonListAdmin();
        }
        return instance;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
    public void addAdmin(Admin newAdmin) {
        admins.add(newAdmin);
    }
    public Admin getCurrentUser(String username) {
        for (Admin admin: admins
        ) {
            if(admin.getUsername().equals(username)){
                return admin;
            }
        }
        return null;
    }
    public void displayAllAdminInfo(){
        for (User admin: admins
             ) {
            System.out.println(admin.toString());
        }
    }
    @Override
    public void update() {
        fileHandler.saveToFile(Constants.ADMIN_FILE_PATH, admins);
        System.out.println("Admin database updated successfully");
    }
}
