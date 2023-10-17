package com.codegym.HuyC08.Service;

import com.codegym.HuyC08.Entity.Product;
import com.codegym.HuyC08.Entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class UserService {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static final int wrongPasswordCountAttempt = 4;
    public static LinkedList<User> llUser = userFileRead();
    public static User currUser;
    public static User currSeller;

    public static void userFileWrite(LinkedList<User> llUser) {
        try {
            FileWriter writer = new FileWriter("data/user.json");
            gson.toJson(llUser, writer);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Cannot write file");
            System.out.println(ioe.getMessage());
        }
    }
    public static LinkedList<User> userFileRead() {
        try {
            FileReader reader = new FileReader("data/user.json");
            Type typeUser = new TypeToken<LinkedList<User>>(){}.getType();
            LinkedList<User> llUsersRead = gson.fromJson(reader, typeUser);
            return llUsersRead;
        } catch (FileNotFoundException fnf) {
            System.out.println("Can't find file to read");
            System.out.println(fnf.getMessage());
        }
        return null;
    }

    public static void getCurrentUser(String username) {
        for (User user: llUser
             ) {
            if(user.getUserName().equals(username)) {
                currUser = user;
                break;
            }
        }
    }

    public static void getCurrentSeller(int sellerId) {
        for (User seller: llUser
        ) {
            if(seller.getId() == sellerId) {
                currSeller = seller;
                break;
            }
        }
    }

    public static boolean isUserPasswordCorrect(String password) {
        return currUser.getUserPassword().equals(password);
    }

    public static boolean isUserExist(String username){
        for (User user: llUser
             ) {
            if(user.getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }

    public static int getNewUserId() {
        int max = 0;
        for (User user: llUser) {
            if (max < user.getId()) {
                max = user.getId();
            }
        }
        return (max + 1);
    }

    public static void updateUserNewName(String newUserName) {
        llUser.remove(currUser);
        currUser.setUserName(newUserName);
        llUser.add(currUser);
        userFileWrite(llUser);
    }

    public static void updateUserNewPassword(String newUserPassword) {
        llUser.remove(currUser);
        currUser.setUserPassword(newUserPassword);
        llUser.add(currUser);
        userFileWrite(llUser);
    }

    public static void updateUserNewCash(double newCash) {
        llUser.remove(currUser);
        currUser.setUserCash(newCash);
        llUser.add(currUser);

        userFileWrite(llUser);
    }

    public static void updateUserNewCash(double newCash, User user) {
        llUser.remove(user);
        user.setUserCash(newCash);
        llUser.add(user);
        sortUserLinkedList();
        userFileWrite(llUser);
    }

    public static void createNewUser(int newId, String newUserName, String newUserPassword) {
        llUser.add( new User(newId, newUserName, newUserPassword));
        userFileWrite(llUser);
    }

    public static void sortUserLinkedList(){
        Collections.sort(llUser, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getId() - u2.getId();
            }
        });
    }
}


