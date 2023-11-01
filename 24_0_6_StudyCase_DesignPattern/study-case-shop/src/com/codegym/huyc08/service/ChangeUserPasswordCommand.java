package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class ChangeUserPasswordCommand implements Command {
    private CurrentUser currentUser;
    private final Scanner SCANNER = new Scanner(System.in);

    public ChangeUserPasswordCommand(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void execute() {
        System.out.println("Input your new password");
        String newUserPassword = SCANNER.next();
        currentUser.setPassword(newUserPassword);
        System.out.println("Set new password successful");
    }

}
