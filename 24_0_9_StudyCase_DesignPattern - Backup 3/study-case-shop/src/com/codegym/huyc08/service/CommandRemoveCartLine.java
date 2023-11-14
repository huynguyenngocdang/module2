package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandRemoveCartLine implements Command{
    private final Scanner SCANNER;

    public CommandRemoveCartLine() {
        this.SCANNER = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("Input your cart line to remove");
        int choice = SCANNER.nextInt() - 1;
        SingletonShoppingCart.getInstance().removeCartLine(choice);
        System.out.println("Remove cart line " + (choice+1) + "successfully");
    }
}
