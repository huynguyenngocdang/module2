package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserSelectProductManufacturer extends Subject implements Command{
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        String currentManufacturer = SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().getProductManufacturer();
        System.out.println("Your current product manufacturer is " + currentManufacturer);
        Confirm confirm = new Confirmation("change product manufacturer");
        if(confirm.isConfirm()) {
            System.out.println("Input your new product manufacturer");
            String newManufacturer = SCANNER.nextLine();
            SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().setProductManufacturer(newManufacturer);
            Observer observer = SingletonListProduct.getInstance();
            addObserver(observer);
            notifyObserver();
            removeObserver(observer);
        } else {
            System.out.println("You have not change your product manufacturer");
        }
    }
}
