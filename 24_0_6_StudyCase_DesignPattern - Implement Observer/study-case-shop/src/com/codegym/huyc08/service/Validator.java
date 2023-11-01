package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private List<NormalUser> users;
    private List<Admin> admins;
    private Type normalUserType = new TypeToken<List<NormalUser>>(){}.getType();
    private Type adminType = new TypeToken<List<Admin>>(){}.getType();
    private MyFileHandler fileHandler = new MyFileHandler();


    public Validator() {
        users = (List<NormalUser>) fileHandler.readFromFile(Constants.USER_FILE_PATH, normalUserType);
        admins = (List<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, adminType);
    }

    public boolean isLikeable(String inputString, String regex) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputString);
            return matcher.matches();
        }
    public boolean isUserExist(String inputUsername, String inputUserPassword) {
        for (User user: users
             ) {
            if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputUserPassword)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserExist(String inputUsername) {
        for (User user: users
        ) {
            if (user.getUsername().equals(inputUsername)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdminExist(String inputUsername, String inputUserPassword) {
        for (User user: admins
        ) {
            if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputUserPassword)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdminExist(String inputUsername) {
        for (User user: admins
        ) {
            if (user.getUsername().equals(inputUsername)) {
                return true;
            }
        }
        return false;
    }
}
