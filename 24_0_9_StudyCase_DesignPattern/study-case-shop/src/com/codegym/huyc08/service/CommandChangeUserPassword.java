package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserPassword extends Subject implements Command {
    private Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        System.out.println("Input your new password");
        String newPassword = SCANNER.next();
        Observer currentUser = SingletonCurrentUser.getInstance();
        addObserver(currentUser);
        SingletonCurrentUser.getInstance().changeUserPassword(newPassword);
        notifyObserver();
        removeObserver(currentUser);
    }
}
