package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class ChangeAdminNameCommand implements Command {
    private CurrentAdmin currentAdmin;
    private final Scanner SCANNER = new Scanner(System.in);

    public ChangeAdminNameCommand(CurrentAdmin currentAdmin) {
        this.currentAdmin = currentAdmin;
    }

    @Override
    public void execute() {
        System.out.println("Input your new username");
        String newUsername = SCANNER.next();
        currentAdmin.setAdminName(newUsername);
        System.out.println("Set new username successful");
    }
}
