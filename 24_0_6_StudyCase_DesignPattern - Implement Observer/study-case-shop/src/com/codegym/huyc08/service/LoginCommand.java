package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.menu.NavigationUser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginCommand implements Command {
    private MyFileHandler fileHandler = new MyFileHandler();
    private Type normalUserType = new TypeToken<ArrayList<NormalUser>>(){}.getType();
    private Type adminType = new TypeToken<ArrayList<Admin>>(){}.getType();
    private List<NormalUser> normalUsers;
    private List<Admin> admins;
    private String inputUsername;
    private String inputPassword;
    private Scanner SCANNER = new Scanner(System.in);
    private NavigationUser navigationUser;
    private Validator validator = new Validator();

    public LoginCommand() {
        normalUsers = (ArrayList<NormalUser>) fileHandler.readFromFile(Constants.USER_FILE_PATH, normalUserType);
        admins = (ArrayList<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, adminType);
    }

    public void setInputUsername(String inputUsername) {
        this.inputUsername = inputUsername;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    @Override
    public void execute() {
        System.out.println("Input username");
        this.inputUsername = SCANNER.next();
        System.out.println("Input password");
        this.inputPassword = SCANNER.next();

        if(validator.isLikeable(this.inputUsername, Constants.ADMIN_REGEX)) {
            if (validator.isAdminExist(this.inputUsername, this.inputPassword)) {
                System.out.println("Login successful");


            }
        } else {
            if(validator.isUserExist(this.inputUsername, this.inputPassword)) {
                System.out.println("Login successful");
                navigationUser =  new NavigationUser(getCurrentUser(), this.normalUsers);
                navigationUser.navigationUserMenu();
            } else {
                System.out.println("Wrong username or password");
            }
        }
    }


    private User getCurrentUser() {
        for (User user: normalUsers
        ) {
            if(user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
                return user;
            }
        }
        return null;
    }

    private User getCurrentAdmin() {
        for (User user: admins
        ) {
            if(user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
                return user;
            }
        }
        return null;
    }
}
