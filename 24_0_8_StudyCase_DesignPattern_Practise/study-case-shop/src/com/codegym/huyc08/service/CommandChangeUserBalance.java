package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandChangeUserBalance implements Command {
    private final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Input your new balance");
        double newAmount = SCANNER.nextDouble();
        ListManagementUser.changeUserBalance(newAmount);
        System.out.println("Recharge cash successful");
    }
}
