package com.codegym.huyc08.backup;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.UserFactory;
import com.codegym.huyc08.entity.UserType;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.Subject;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorUserNameExist;
import com.codegym.huyc08.service.ValidatorRegexString;

import java.util.Scanner;

public class CommandCreateNewUserBackup extends Subject implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    private Observer observer;

    public CommandCreateNewUserBackup() {
        this.observer = SingletonListNormalUser.getInstance();
    }
    @Override
    public void execute() {
        System.out.println("Input your username");
        String username = SCANNER.next();
        System.out.println("Input your password");
        String password = SCANNER.next();
        addObserver(observer);

        //Validate - create new user

        if (checkUserSyntax(username)){
            var factory = new UserFactory();
            int newId = SingletonListNormalUser.getInstance().getNewId();
            var newUser = factory.createUser(newId, username,password, 0, UserType.NORMAL, "HCM City", true);
            SingletonListNormalUser.getInstance().addUser((NormalUser) newUser);
            notifyObserver();

        } else {
            System.out.println("Username must have at least 3 character");
        }
    }

    private boolean checkUserSyntax(String username) {
        Validator validator = new ValidatorRegexString(username, Constants.USER_REGEX);
        return validator.isCheck();
    }
    private boolean checkUserExist(String username) {
        Validator validator = new ValidatorUserNameExist(username);
        return validator.isCheck();
    }
}
