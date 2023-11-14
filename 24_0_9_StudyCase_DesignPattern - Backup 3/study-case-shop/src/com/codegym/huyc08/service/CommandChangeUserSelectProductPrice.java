package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserSelectProductPrice extends Subject implements Command{
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        double currentPrice = SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().getProductPrice();
        System.out.println("Your current product price is " + currentPrice);
        Confirm confirm = new Confirmation("change product price");
        if(confirm.isConfirm()) {
            System.out.println("Input your new product price");
            double newPrice = SCANNER.nextDouble();
            Validator validator = new ValidatorDoubleNotNegative(newPrice);
            if(validator.isCheck()) {
                SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().setProductPrice(newPrice);
                Observer observer = SingletonListProduct.getInstance();
                addObserver(observer);
                notifyObserver();
                removeObserver(observer);
            } else {
                System.out.println("You can't input a negative value for price");
            }
        } else {
            System.out.println("You have not change your product price");
        }
    }
}
