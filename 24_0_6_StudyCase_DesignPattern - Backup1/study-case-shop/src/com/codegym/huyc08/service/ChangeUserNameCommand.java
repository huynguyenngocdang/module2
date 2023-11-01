package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.menu.Command;

import java.util.List;
import java.util.Scanner;

public class ChangeUserNameCommand implements Command {
    private CurrentUser currentUser;
    private final Scanner SCANNER = new Scanner(System.in);

    public ChangeUserNameCommand(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void execute() {
        System.out.println("Input your new username");
        String newUsername = SCANNER.next();
        currentUser.setUsername(newUsername);
        System.out.println("Set new username successful");
    }
//    private User currentUser;
//    private List<NormalUser> users;
//    private MyFileHandler fileHandler = new MyFileHandler();
//    private final Scanner SCANNER = new Scanner(System.in);
//    private final Validator validator = new Validator();
//
//    public ChangeUserNameCommand(User currentUser, List<NormalUser> users) {
//        this.currentUser = currentUser;
//        this.users = users;
//    }
//
//    @Override
//    public void execute() {
//        // Execute the command that changes the username
//        System.out.println("Input your new username");
//        String newUsername = SCANNER.next();
//        if (validator.isLikeable(newUsername, Constants.ADMIN_REGEX)) {
//            System.out.println("Your username can't start like admin");
//        } else if (validator.isUserExist(newUsername)) {
//            System.out.println("Username already exist in database");
//        } else if (validator.isLikeable(newUsername, Constants.USER_REGEX)) {
//            currentUser.setUsername(newUsername);
//            update();
//        } else {
//            System.out.println("Your username must have at least 3 character");
//        }
//
//    }
//
//    @Override
//    public void update() {
//        // Handle the update of the current user information
//        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
//    }
}

