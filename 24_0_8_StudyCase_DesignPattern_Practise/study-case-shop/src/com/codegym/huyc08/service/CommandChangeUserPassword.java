package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandChangeUserPassword implements Command {
    private final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Input your new password");
        String newPassword = SCANNER.next();

        ListManagementUser.changeUserPassword(newPassword);
        System.out.println("password update successful");
    }
}

