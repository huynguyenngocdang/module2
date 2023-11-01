package com.codegym.huy_c08.service;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.NormalUser;
import com.codegym.huy_c08.entity.User;
import com.codegym.huy_c08.entity.UserFactory;
import com.codegym.huy_c08.menu.MenuConsole;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codegym.huy_c08.entity.UserType.NORMAL;

public class NormalUserService implements UserServiceInterface {
    private ArrayList<User> users;
    private MyFileHandler fileHandler = new MyFileHandler();
    private User currentUser;
    private UserFactory userFactory = new UserFactory();
    private Type userType = new TypeToken<ArrayList<NormalUser>>() {
    }.getType();
    private MenuConsole menuConsole = new MenuConsole();

    public NormalUserService() {
        this.users = (ArrayList<User>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
    }

    public void refresh() {
        this.users = (ArrayList<User>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
    }

    @Override
    public void logIn(String username, String password) {
        if (isUserExist(username)) {
            if (isUserLoginCorrect(username, password)) {
                System.out.println("Login in");
                currentUser = userLogin(username, password);
            } else {
                System.out.println("Wrong password");
            }
        } else {
            System.out.println("User does not exist in database");
        }
    }

    @Override
    public boolean isUserExist(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isUserLoginCorrect(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User userLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void userCreate(String username, String password) {
        int newId = getNewId();
        if (isLikableAdmin(username)) {
            System.out.println("Cannot create new username start with admin_");
        } else if (isInvalidUsername(username)) {
            System.out.println("Username must have at least 3 character with no special characters");
        } else if (isUserExist(username)) {
            menuConsole.printTypeAlreadyExist("user");
        } else {
                User newUser = userFactory.createUser(newId, username, password, 0, NORMAL, true);
                users.add(newUser);
                fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
                users = (ArrayList<User>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
            }

    }

    private boolean isLikableAdmin(String username) {
        Pattern pattern = Pattern.compile(Constants.ADMIN_REGEX);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public boolean isInvalidUsername(String username) {
        Pattern pattern = Pattern.compile(Constants.USER_REGEX);
        Matcher matcher = pattern.matcher(username);
        return !matcher.matches();
    }

    private int getNewId() {
        int max = 0;
        for (User user: users
             ) {
            if (max < user.getUserId()) {
                max = user.getUserId();
            }
        }
        return max + 1;
    }

    private void sortUserList() {
        Collections.sort(users, Comparator.comparingInt(User::getUserId));
    }

    @Override
    public void getCurrentUserInformation() {
        menuConsole.printCurrentUserInformationHeader();
        System.out.println(currentUser.toString());
    }

    public void updateUsers() {
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
    }

    public void changeUserName(String newUsername) {
        if (isLikableAdmin(newUsername)) {
            menuConsole.printUserSimilarAdmin();
        } else if (isInvalidUsername(newUsername)) {
           menuConsole.printUserInvalidName();
        } else if (isUserExist(newUsername)) {
            menuConsole.printTypeAlreadyExist("user");
        } else {
            currentUser.setUsername(newUsername);
        }
    }
    public void changeUserPassword(String newUserPassword) {
        currentUser.changePassword(newUserPassword);
    }
    public void changeUserAmount(double newAmount) {
        currentUser.setWalletBalance(newAmount + currentUser.getWalletBalance());
    }
    public void getCurrentUserCash() {
        System.out.println("Your current cash " + currentUser.getWalletBalance());
    }
    public int getCurrentUserId(){
        return currentUser.getUserId();
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isEnoughUserCash(double amount) {
        return ( (currentUser.getWalletBalance() - amount) >= 0 );
    }
    public void updateUserNewCash(double amount) {
        currentUser.setWalletBalance(currentUser.getWalletBalance() - amount);
        updateUsers();
    }
    public double getCurrentUserBalance() {
        return currentUser.getWalletBalance();
    }
    public boolean getCurrentUserStatus(){
        return currentUser.isActive();
    }
}

