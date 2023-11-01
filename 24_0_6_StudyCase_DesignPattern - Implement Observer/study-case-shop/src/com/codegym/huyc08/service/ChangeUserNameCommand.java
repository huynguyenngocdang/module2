package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

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

}

