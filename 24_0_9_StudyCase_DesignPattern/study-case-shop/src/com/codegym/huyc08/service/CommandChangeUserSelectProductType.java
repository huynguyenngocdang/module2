package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserSelectProductType extends Subject implements Command{
    private  Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        String currentType = SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().getProductType();
        System.out.println("Your current product type is " + currentType);
        Confirm confirm = new Confirmation("change product type");
        if(confirm.isConfirm()) {
            System.out.println("Input your new product type");
            String newType = SCANNER.next();
            SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().setProductType(newType);
            Observer observer = SingletonListProduct.getInstance();
            addObserver(observer);
            notifyObserver();
            removeObserver(observer);
        } else {
            System.out.println("You have not change your product type");
        }
    }
}
