package com.codegym.huyc08.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandRemoveCartLine implements Command{
    private  Scanner SCANNER;
    @Override
    public void execute() {
        try {
            if(SingletonShoppingCart.getInstance().getCartItems().isEmpty()) {
                System.out.println("Your cart is empty, nothing to remove");
            } else {
                SCANNER = new Scanner(System.in);
                System.out.println("Input your cart line to remove");
                int choice = SCANNER.nextInt() - 1;
                SingletonShoppingCart.getInstance().removeCartLine(choice);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again");
        }

    }
}
