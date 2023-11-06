package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandChangeUserActive extends Subject implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input user id ");
        int userId = SCANNER.nextInt();
        if(isUserIdExist(userId)) {
            setCurrentUser(userId);
            System.out.println("Current user is " + (getCurrentUserStatus()? "active" : "banned"));
            System.out.println("Do you want to change this user status?(Y/N)");
            String userConfirm = SCANNER.next().toLowerCase();
            switch (userConfirm) {
                case Constants.USER_CONFIRM:
                    Observer observer = SingletonCurrentUser.getInstance();
                    addObserver(observer);
                    SingletonCurrentUser.getInstance().changeUserStatus();
                    notifyObserver();
                    removeObserver(observer);
                    break;
                case Constants.USER_REJECT:
                    System.out.println("You have not yet change this user status");
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }
        } else {
            System.out.println("User id does not exist in database");
        }

    }
    private boolean isUserIdExist(int userId) {
        Validator validator = new ValidatorUserIdExist(userId);
        return validator.isCheck();
    }
    private void setCurrentUser(int userId) {
        SingletonCurrentUser.getInstance().setCurrentUser(userId);
    }
    private boolean getCurrentUserStatus(){
        return SingletonCurrentUser.getInstance().getCurrentUserStatus();
    }
}
