package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.entity.UserFactory;
import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.menu.NavigationLogin;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.codegym.huyc08.entity.UserType.NORMAL;

public class CreateNewUserCommand implements Command, Observer {
    private Validator validator = new Validator();
    private final Scanner SCANNER = new Scanner(System.in);
    private UserFactory userFactory = new UserFactory();
    private MyFileHandler fileHandler = new MyFileHandler();
    private Type userType = new TypeToken<ArrayList<NormalUser>>(){}.getType();
    private ArrayList<NormalUser> users;

    public CreateNewUserCommand() {
        this.users = (ArrayList<NormalUser>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
    }

    @Override
    public void execute() {
        System.out.println("Input new username");
        String newUsername = SCANNER.next();
        if (validator.isUserExist(newUsername)) {
            System.out.println("User already exist, please choose another name");
        } else if (validator.isLikeable(newUsername, Constants.ADMIN_REGEX)) {
            System.out.println("Username can't be similar to admin");
        } else {
            System.out.println("Input new user password");
            String newUserPassword = SCANNER.next();
            int newId = getNewId();
            User newUser = userFactory.createUser(newId,newUsername, newUserPassword,0, NORMAL, true);
            users.add((NormalUser) newUser);
            update();

            NavigationLogin login = new NavigationLogin();
            login.navigationLogin();
        }
    }
    private int getNewId() {
        int max = 0;
        for (User user: users
             ) {
            if (max < user.getUserId()) {
                max = user.getUserId();
            }
        }
        return max + 1;
    }

    @Override
    public void update() {
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
    }
}
