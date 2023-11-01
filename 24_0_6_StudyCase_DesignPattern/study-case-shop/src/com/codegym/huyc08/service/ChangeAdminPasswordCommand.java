package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class ChangeAdminPasswordCommand implements Command {
    private CurrentAdmin currentAdmin;
    private final Scanner SCANNER = new Scanner(System.in);

    public ChangeAdminPasswordCommand(CurrentAdmin currentAdmin) {
        this.currentAdmin = currentAdmin;
    }

    @Override
    public void execute() {
        System.out.println("Input your new password");
        String newUserPassword = SCANNER.next();
        currentAdmin.setAdminPassword(newUserPassword);
        System.out.println("Set new password successful");
    }
}
