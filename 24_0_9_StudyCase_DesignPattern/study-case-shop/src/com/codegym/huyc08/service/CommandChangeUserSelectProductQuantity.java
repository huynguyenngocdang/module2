package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserSelectProductQuantity extends Subject implements Command{
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        double currentQuantity = SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().getProductQuantity();
        System.out.println("Your current product quantity is " + currentQuantity);
        Confirm confirm = new Confirmation("change product quantity");
        if(confirm.isConfirm()) {
            System.out.println("Input your new product quantity");
            double newQuantity = SCANNER.nextDouble();
            Validator validator = new ValidatorDoubleNotNegative(newQuantity);
            if(validator.isCheck()) {
                SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().setProductQuantity(newQuantity);
                Observer observer = SingletonListProduct.getInstance();
                addObserver(observer);
                notifyObserver();
                removeObserver(observer);
            } else {
                System.out.println("You can't input a negative value for quantity");
            }
        } else {
            System.out.println("You have not change your product quantity");
        }
    }
}
