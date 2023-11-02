package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandChangeUserName implements Command {
    private final  Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input your new username");
        String newUsername = SCANNER.next();
        Validator validator = new ValidatorUserExist(newUsername);
        Validator validatorName = new ValidatorUser(newUsername);
        Validator validatorAdmin = new ValidatorAdmin(newUsername);
        if(validator.isCheck()) {
            System.out.println("Username already exist in database");
        } else if (validatorAdmin.isCheck()) {
            System.out.println("User can't start same as admin");
        } else {
            if (validatorName.isCheck()) {
                ListManagementUser.changeUsername(newUsername);
                System.out.println("Username update successful");
            } else {
                System.out.println("Username must have at least 3 characters");
            }
        }
    }
}
