package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CurrentAdmin implements Observer {
    private User admin;
    private List<Admin> admins;
    private List<NormalUser> users;
    private Type userType = new TypeToken<ArrayList<NormalUser>>(){}.getType();

    private MyFileHandler fileHandler = new MyFileHandler();
    private final Validator validator = new Validator();

    public CurrentAdmin(User admin, List<Admin> admins) {
        this.admin = admin;
        this.admins = admins;
        this.users = (ArrayList<NormalUser>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
    }

    public void setAdminName(String newAdminName) {
        if (validator.isAdminExist(newAdminName)) {
            System.out.println("This admin name already taken");
        } else if (validator.isLikeable(newAdminName, Constants.ADMIN_REGEX)){
            admin.setUsername(newAdminName);
            update();
        } else {
            System.out.println("Admin name must begin with admin_ and at least 2 number");
        }
    }
    public void setAdminPassword(String newAdminPassword) {
        admin.setPassword(newAdminPassword);
        update();

    }

@Override
    public void update() {
        fileHandler.saveToFile(Constants.ADMIN_FILE_PATH, admins);
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
    }
}
