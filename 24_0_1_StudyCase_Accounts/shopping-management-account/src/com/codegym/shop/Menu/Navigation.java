package com.codegym.shop.Menu;

import com.codegym.shop.Entity.User;
import com.codegym.shop.Service.UserService;

import java.util.Scanner;

public class Navigation {
    private static final Scanner scanner = new Scanner(System.in);
    public static void userMenuLoginNavigation(){
        int choice;
        String username;
        String password;
        boolean isLoggingIn = false;
        do {
            Menu.userLoginMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Menu.inputUsername();
                    username = scanner.next();
                    Menu.inputPassword();
                    password = scanner.next();
                    if (UserService.validateUser(username, password)) {
                        UserService.loginUser(username, password);
                        isLoggingIn = true;
                }
                    break;
                case 2:
                    Menu.inputUsername("new");
                    username = scanner.next();
                    Menu.inputPassword("new");
                    password = scanner.next();
                    User userNew = new User(username, password, "normal",0, false, false, false, false, false, false, true);
                    UserService.createUser(username, userNew);
                    break;
                case 99:
                    UserService.checkUser();
                    break;
                case 0:
                    System.out.println("You choose to exit");
                    break;
                default:
                    Menu.inputInvalid();
                    break;
            }
        } while (choice != 0 && !isLoggingIn);
    }
    public static void userMenuMainNavigation() {
        int choice;
        do{
            UserService.welcomeCurrentUser();
            Menu.userMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    UserService.checkCurrentUserDetail();
                    break;
                case 2:
                    Menu.inputUsername("new");
                    UserService.changeCurrentUserName(scanner.next());
                    break;
                case 3:
                    Menu.inputPassword("new");
                    UserService.changeCurrentUserPassword(scanner.next());
                    break;
                case 4:
                    Menu.inputNewCash();
                    UserService.changeCurrentUserCash(scanner.nextInt());
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;

                case 99:
                    UserService.checkCurrentUserList();
                    break;
                case 0:
                    System.out.println("Logging out");
                    userMenuLoginNavigation();
                    break;
                default:
                    Menu.inputInvalid();
                    break;
            }
        } while (choice != 0);

    }
}
