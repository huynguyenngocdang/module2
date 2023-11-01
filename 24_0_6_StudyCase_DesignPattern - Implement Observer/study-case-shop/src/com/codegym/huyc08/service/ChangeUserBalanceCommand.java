package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class ChangeUserBalanceCommand implements Command {
    private CurrentUser currentUser;
    private final Scanner SCANNER = new Scanner(System.in);

    public ChangeUserBalanceCommand(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void execute() {
        System.out.println("Input your new user balance");
        int newUserBalance = SCANNER.nextInt();
        currentUser.setBalance(newUserBalance);
        System.out.println("Set new balance successful");
    }
}
