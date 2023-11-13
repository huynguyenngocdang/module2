package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserSelectProductDescription extends Subject implements Command{
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        String currentDescription = SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().getProductDescription();
        System.out.println("Your current product description is " + currentDescription);
        Confirm confirm = new Confirmation("change product description");
        if(confirm.isConfirm()) {
            System.out.println("Input your new product description");
            String newDescription = SCANNER.nextLine();
            SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().setProductDescription(newDescription);
            Observer observer = SingletonListProduct.getInstance();
            addObserver(observer);
            notifyObserver();
            removeObserver(observer);
        } else {
            System.out.println("You have not change your product description");
        }
    }
}
