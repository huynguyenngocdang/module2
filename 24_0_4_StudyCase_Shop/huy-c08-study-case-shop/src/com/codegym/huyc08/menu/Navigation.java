package com.codegym.huyc08.menu;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.service.MyFileHandler;
import com.codegym.huyc08.service.UserService;

import java.util.Scanner;

public class Navigation {

    private final MenuConsole menuConsole = new MenuConsole();
    private final MenuMain menuMain = new MenuMain();
    private final Scanner SCANNER = new Scanner(System.in);
    private final MyFileHandler fileHandler = new MyFileHandler();
    private final UserService userService = new UserService();

    public Navigation() {
    }

    public void navigationLogin() {
        int userChoice = Constants.USER_CHOICE_INIT;
        while (userChoice != Constants.USER_CHOICE_EXIT) {
            menuMain.MenuLogin();
            userChoice = SCANNER.nextInt();
            switch (userChoice) {
                case Constants.USER_CHOICE_EXIT:
                    System.exit(0);
                    break;
                case Constants.USER_CHOICE_1:
                    menuConsole.printUserInput("username");
                    String usernameLogin = SCANNER.next();
                    menuConsole.printUserInput("password");
                    String userPasswordLogin = SCANNER.next();
                    break;
                default:
                    menuConsole.invalidInput("choice");
                    break;
            }

        }
    }
}
