package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandChangeAdminPassword extends Subject implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        try {
            System.out.println("Input your new password");
            String newPassword = SCANNER.next();
            Observer observer = SingletonCurrentAdmin.getInstance();
            addObserver(observer);
            SingletonCurrentAdmin.getInstance().changeAdminPassword(newPassword);
            notifyObserver();
            removeObserver(observer);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }
}
