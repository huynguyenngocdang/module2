package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserSelectProductName extends Subject implements Command{
    private Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        String currentName = SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().getProductName();
        System.out.println("Your current product name is " + currentName);
        Confirm confirm = new Confirmation("change product name");
        if(confirm.isConfirm()) {
            System.out.println("Input your new product name");
            String newName = SCANNER.nextLine();
            SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().setProductName(newName);
            Observer observer = SingletonListProduct.getInstance();
            addObserver(observer);
            notifyObserver();
            removeObserver(observer);
        } else {
            System.out.println("You have not change your product name");
        }
    }
}
