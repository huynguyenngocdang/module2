package com.codegym.huyc08.service;

import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDoubleNotNegative;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandChangeUserSelectProductQuantity extends Subject implements Command{
    private  Scanner SCANNER ;
    @Override
    public void execute() {
        try {
            SCANNER = new Scanner(System.in);
            double currentQuantity = SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().getProductQuantity();
            System.out.println("Your current product quantity is " + currentQuantity);
            Confirm confirm = new Confirmation("change product quantity");
            if (confirm.isConfirm()) {
                System.out.println("Input your new product quantity");
                double newQuantity = SCANNER.nextDouble();
                Validator validator = new ValidatorDoubleNotNegative(newQuantity);
                if (validator.isCheck()) {
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

        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
        }
    }
}
