package com.codegym.huyc08.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandChangeUserBalance extends Subject implements Command {
    private  Scanner SCANNER;
    @Override
    public void execute() {
        try {
            SCANNER = new Scanner(System.in);
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
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
        }


    }
}
