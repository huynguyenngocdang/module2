package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;

import java.util.Scanner;

public class Confirmation implements Confirm{
    private String action;
    private final Scanner SCANNER;

    public Confirmation(String action) {
        this.action = action;
        this.SCANNER = new Scanner(System.in);
    }

    @Override
    public boolean isConfirm() {
        System.out.println("Do you want to " + this.action);
        String choice = SCANNER.next().toLowerCase();
        switch (choice) {
            case Constants.USER_CONFIRM:
                return true;
            default:
                return false;
        }

    }
}
