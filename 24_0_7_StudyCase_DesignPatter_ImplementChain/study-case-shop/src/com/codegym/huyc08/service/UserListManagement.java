package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserListManagement {
    private static List<NormalUser> users;
    private static NormalUser currentUser;
    private static final Type USERTYPE = new TypeToken<ArrayList<NormalUser>>(){}.getType();
    private static final MyFileHandler fileHandler = new MyFileHandler();

    public UserListManagement()  {
            users = (ArrayList<NormalUser>) fileHandler.readFromFile(Constants.USER_FILE_PATH, USERTYPE);
    }

    public static List<NormalUser> getUsers() {
        return users;
    }

    public static void setCurrentUser(String username, String password) {
        for (NormalUser user: users
             ) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
            }
        }
    }

    public static NormalUser getCurrentUser() {
        return currentUser;
    }
    public static String getCurrentUserName(){
        return currentUser.getUsername();
    }
    public static String getCurrentUserPassword(){
        return currentUser.getPassword();
    }
    public static void changeCurrentUserName(String newUsername) {
        currentUser.setUsername(newUsername);
        update();
    }
    public static void changeCurrentUserPassword(String newPassword) {
        currentUser.setPassword(newPassword);
        update();
    }
    private static void update() {
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
    }

}
