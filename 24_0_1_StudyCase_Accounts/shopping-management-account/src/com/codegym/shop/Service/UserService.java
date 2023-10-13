package com.codegym.shop.Service;

import com.codegym.shop.Menu.Navigation;
import com.codegym.shop.Entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class UserService {
    private static LinkedList<User> users = new LinkedList<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static User currUser;

    private static void writeUser() {
        try {
            FileWriter writer = new FileWriter("user.json");
            gson.toJson(users, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readUser() {
        try {
            FileReader reader = new FileReader("user.json");
            Type userType = new TypeToken<LinkedList<User>>(){}.getType();
            users = gson.fromJson(reader, userType);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createUser(String name, User userNew) {
        readUser();
        if (userExist(name)) {
            System.out.println("User already exist in database, get new name");
        } else {
            users.add(userNew);
        }

        writeUser();
    }

    public static boolean userExist(String name) {
        readUser();
        for (User user: users
             ) {
            if(user.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static void checkUser() {
        readUser();
        users.forEach(user -> System.out.println(user.toString()));
    }

    public static void checkCurrentUserList() {

        users.forEach(user -> System.out.println(user.toString()));
    }
    public static void loginUser(String username, String password) {

        readUser();
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getUserPassword().equals(password)) {
                currUser = user;
            }
        }
        System.out.println("Log in as " + currUser.getUserName());
        Navigation.userMenuMainNavigation();
    }

    public static boolean validateUser(String username, String password) {
        boolean isCorrectUser =false;
        readUser();
        for (User user: users) {
            if(user.getUserName().equals(username) && user.getUserPassword().equals(password)){
                isCorrectUser = true;
                break;
            }
        }
        return isCorrectUser;
    }

    public static void checkCurrentUserDetail() {
        System.out.println(currUser.toString());
    }
    public static void welcomeCurrentUser() {
        System.out.println("Welcome " + currUser.getUserName());
    }
    public static void changeCurrentUserName(String newUserName) {
        users.remove(currUser);
        currUser.setUserName(newUserName);
        users.add(currUser);
        writeUser();
    }
    public static void changeCurrentUserPassword(String newUserPassword) {
        users.remove(currUser);
        currUser.setUserPassword(newUserPassword);
        users.add(currUser);
        writeUser();
    }

    public static void changeCurrentUserCash(int newCashAmount){
        users.remove(currUser);
        currUser.setCurrentCash(newCashAmount);
        users.add(currUser);
        writeUser();
    }




}
