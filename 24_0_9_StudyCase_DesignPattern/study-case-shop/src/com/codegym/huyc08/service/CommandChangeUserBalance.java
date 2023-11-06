package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserBalance extends Subject implements Command {
    private final  Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Recharge your wallet amount");
        double newAmount = SCANNER.nextDouble();
        Observer currentUser = SingletonCurrentUser.getInstance();
        addObserver(currentUser);
        if (newAmount >= 0) {
            SingletonCurrentUser.getInstance().changeUserBalance(newAmount);
            notifyObserver();
            removeObserver(currentUser);
        } else {
            System.out.println("You can't recharge with negative number");
        }

    }
}
