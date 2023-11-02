package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Admin;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListManagementAdmin {
    private static Admin currentAdmin;
    private static final Type ADMINTYPE = new TypeToken<ArrayList<Admin>>(){}.getType();
    private static final MyFileHandler fileHandler = new JsonFileHandler();
    private static List<Admin> admins = (ArrayList<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, ADMINTYPE);;

    public static ArrayList<Admin> getUserList() {
        return (ArrayList<Admin>) admins;
    }
    private static void update() {
        fileHandler.saveToFile(Constants.USER_FILE_PATH, admins);
        admins = (ArrayList<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, ADMINTYPE);
    }
    public static void setCurrentAdmin(String username, String password) {
        for (Admin admin : admins) {
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                currentAdmin = admin;
            }
        }
    }
    public static Admin getCurrentAdmin() {
        return currentAdmin;
    }
    public static int getCurrentAdminId() {
        return currentAdmin.getUserId();
    }
    public static  String getCurrentAdminName() {
        return currentAdmin.getUsername();
    }
    public static  String getCurrentAdminPassword() {
        return currentAdmin.getPassword();
    }
    public static  double getCurrentAdminBalance() {
        return currentAdmin.getWalletBalance();
    }
    public static  boolean getCurrentAdminStatus(){
        return currentAdmin.isActive();
    }
    public static  void changeAdminName(String newAdminName) {
        currentAdmin.setUsername(newAdminName);
        update();
    }
    public static  void changeAdminPassword(String newAdminPassword) {
        currentAdmin.setPassword(newAdminPassword);
        update();
    }
    public static void changeAdminBalance(double newAmount){
        currentAdmin.setWalletBalance(currentAdmin.getWalletBalance() + newAmount);
        update();
    }
}
