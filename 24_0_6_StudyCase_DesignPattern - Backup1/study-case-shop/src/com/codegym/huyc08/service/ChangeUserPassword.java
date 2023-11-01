package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.menu.Command;

import java.util.List;
import java.util.Scanner;

public class ChangeUserPassword implements Command {
    private CurrentUser currentUser;
    private final Scanner SCANNER = new Scanner(System.in);

    public ChangeUserPassword(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void execute() {
        System.out.println("Input your new password");
        String newUserPassword = SCANNER.next();
        currentUser.setPassword(newUserPassword);
        System.out.println("Set new password successful");
    }
//    private User currentUser;
//    private List<NormalUser> users;
//    private MyFileHandler fileHandler = new MyFileHandler();
//    private final Scanner SCANNER = new Scanner(System.in);
//    private final Validator validator = new Validator();
//
//    public ChangeUserPassword(User currentUser, List<NormalUser> users) {
//        this.currentUser = currentUser;
//        this.users = users;
//    }
//
//    @Override
//    public void execute() {
//        // Execute the command that changes the username
//        System.out.println("Input your new password");
//        String newUserPassword = SCANNER.next();
//        currentUser.setPassword(newUserPassword);
//        update();
//
//
//    }
//
//    @Override
//    public void update() {
//        // Handle the update of the current user information
//        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
//    }
}
