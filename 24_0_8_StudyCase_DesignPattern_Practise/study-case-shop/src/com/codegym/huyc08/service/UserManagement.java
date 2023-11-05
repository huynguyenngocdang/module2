package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserManagement{

    private static NormalUser currentUser;
    private static Admin currentAdmin;
    private static final Type USERTYPE = new TypeToken<ArrayList<NormalUser>>() {
    }.getType();
    private static final Type ADMINTYPE = new TypeToken<ArrayList<Admin>>() {
    }.getType();
    private static final MyFileHandler fileHandler = new JsonFileHandler();
    private static List<Admin> admins = (ArrayList<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, ADMINTYPE) ;
    private static List<NormalUser> normalUsers = (ArrayList<NormalUser>)fileHandler.readFromFile(Constants.USER_FILE_PATH, USERTYPE) ;


    public static void addUser(User user) {
        if (user instanceof Admin) {
            admins.add((Admin) user);
        } else if (user instanceof NormalUser) {
            normalUsers.add((NormalUser) user);
        }
    }

    public static List<Admin> getAdmins() {
        return admins;
    }

    public static List<NormalUser> getNormalUsers() {
        return normalUsers;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentAdmin(String username, String password) {
        for (Admin user : admins) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentAdmin = user;
                return;
            }
        }
        currentAdmin = null;
    }

    public static void setCurrentNormalUser(String username, String password) {
        for (NormalUser user : normalUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return;
            }
        }
      currentUser = null;
    }
    private void update(){
        fileHandler.saveToFile(Constants.USER_FILE_PATH, normalUsers);
        fileHandler.saveToFile(Constants.ADMIN_FILE_PATH, admins);
    }
}


