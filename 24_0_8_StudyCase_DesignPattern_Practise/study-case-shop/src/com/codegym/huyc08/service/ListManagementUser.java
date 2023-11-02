package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListManagementUser {

    private static NormalUser currentUser;
    private static final Type USERTYPE = new TypeToken<ArrayList<NormalUser>>(){}.getType();
    private static final MyFileHandler fileHandler = new JsonFileHandler();
    private static List<NormalUser> users = (ArrayList<NormalUser>) fileHandler.readFromFile(Constants.USER_FILE_PATH, USERTYPE);;

    public static ArrayList<NormalUser> getUserList() {
        return (ArrayList<NormalUser>) users;
    }
    private static void update() {
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
        users = (ArrayList<NormalUser>) fileHandler.readFromFile(Constants.USER_FILE_PATH, USERTYPE);
    }

    public static NormalUser getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(String username, String password) {
        for (NormalUser user: users
             ) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
            }
        }
    }
    public static int getCurrentUserId() {
        return currentUser.getUserId();
    }
    public static  String getCurrentUserName() {
        return currentUser.getUsername();
    }
    public static  String getCurrentUserPassword() {
        return currentUser.getPassword();
    }
    public static  double getCurrentUserBalance() {
        return currentUser.getWalletBalance();
    }
    public static  boolean getCurrentUserStatus(){
        return currentUser.isActive();
    }
    public static void changeUsername(String newUsername) {
        currentUser.setUsername(newUsername);
        update();
    }
    public static  void changeUserPassword(String newUserPassword) {
        currentUser.setPassword(newUserPassword);
        update();
    }
    public static void changeUserBalance(double newAmount){
        currentUser.setWalletBalance(currentUser.getWalletBalance() + newAmount);
        update();
    }


}
