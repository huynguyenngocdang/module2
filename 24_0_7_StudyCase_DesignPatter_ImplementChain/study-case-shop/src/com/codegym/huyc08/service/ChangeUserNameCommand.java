package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class ChangeUserNameCommand implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input new username");
        String newUsername = SCANNER.next();
        UserListManagement.changeCurrentUserName(newUsername);
    }
}
