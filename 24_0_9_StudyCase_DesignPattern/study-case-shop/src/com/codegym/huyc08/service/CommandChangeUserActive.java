package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.MessageFactory;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorUserIdExist;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandChangeUserActive extends Subject implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    private int adminId;

    public CommandChangeUserActive(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Input user id ");
            int userId = SCANNER.nextInt();
            if(isUserIdExist(userId)) {
                setCurrentUser(userId);
                System.out.println("Current user is " + (getCurrentUserStatus()? "active" : "banned"));
                Confirm confirm = new Confirmation("change this user status");
                if(confirm.isConfirm()){
                    Observer observerUser = SingletonCurrentUser.getInstance();
                    Observer observerMessage = SingletonListMessage.getInstance();
                    MessageFactory factory = new MessageFactory();
                    addObserver(observerUser);
                    addObserver(observerMessage);


                    SingletonCurrentUser.getInstance().changeUserStatus();
                    SingletonListMessage.getInstance().getMessages().add(factory.createMessage(adminId, SingletonCurrentUser.getInstance().getCurrentUser().getUserId(), "You have been " + ((getCurrentUserStatus()? "unbanned" : "banned"))));
                    notifyObserver();

                    removeObserver(observerUser);
                    removeObserver(observerMessage);
                } else {
                    System.out.println("You have not yet change this user status");
                }

            } else {
                System.out.println("User id does not exist in database");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
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
