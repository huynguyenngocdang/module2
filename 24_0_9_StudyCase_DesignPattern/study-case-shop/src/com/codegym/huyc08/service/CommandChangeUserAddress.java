package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserAddress extends Subject implements Command{
    private Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        String currentUserAddress = SingletonCurrentUser.getInstance().getCurrentUser().getAddress();
        System.out.println("Your current Address is " + currentUserAddress);
        System.out.println("Input your new address");
        String newAddress = SCANNER.nextLine();
        Observer observer = SingletonCurrentUser.getInstance();
        addObserver(observer);
        SingletonCurrentUser.getInstance().changeUserAddress(newAddress);
        notifyObserver();
        removeObserver(observer);
    }
}
