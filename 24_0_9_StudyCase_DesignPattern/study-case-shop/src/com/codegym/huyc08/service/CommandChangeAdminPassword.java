package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeAdminPassword extends Subject implements Command {
    private Scanner SCANNER;
    @Override
    public void execute() {
        try {
            SCANNER = new Scanner(System.in);
            System.out.println("Input your new password");
            String newPassword = SCANNER.next();
            Observer observer = SingletonListAdmin.getInstance();
            addObserver(observer);
            SingletonCurrentAdmin.getInstance().changeAdminPassword(newPassword);
            notifyObserver();
            removeObserver(observer);
        } catch (NullPointerException e) {
            System.out.println("Must input something");
            System.out.println(e.getMessage());
        }

    }
}
