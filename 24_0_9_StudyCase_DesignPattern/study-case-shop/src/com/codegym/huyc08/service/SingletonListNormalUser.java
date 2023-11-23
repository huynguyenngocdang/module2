package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingletonListNormalUser implements Observer, GenerateId {
    private List<NormalUser> users;
    private MyFileHandler fileHandler;
    private static SingletonListNormalUser instance;
    private final Type USERTYPE = new TypeToken<ArrayList<NormalUser>>() {
    }.getType();

    private SingletonListNormalUser() {
        fileHandler = new JsonFileHandler();
        users = (ArrayList<NormalUser>) fileHandler.readFromFile(AppConstant.USER_FILE_PATH, USERTYPE);
        if(users == null) {
            users = new ArrayList<>();
        }
    }

    public static SingletonListNormalUser getInstance() {
        if (instance == null) {
            instance = new SingletonListNormalUser();
        }
        return instance;
    }

    public List<NormalUser> getUsers() {
        return users;
    }

    public void setUsers(List<NormalUser> users) {
        this.users = users;
    }

    public void addUser(NormalUser user) {
        users.add(user);
    }

    public void displayAllUsers() {
        for (User user : users
        ) {
            System.out.println(user.toString());
        }
    }


    public NormalUser getCurrentUser(String username) {
        for (NormalUser user : users
        ) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public NormalUser getCurrentUser(int id) {
        for (NormalUser user : users
        ) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public int getNewId() {
        try {
            int max = 0;
            for (User user : users) {
                if (max < user.getUserId()) {
                    max = user.getUserId();
                }
            }
            return max + 1;
        } catch (NullPointerException e) {
            return 1;
        }

    }

    @Override
    public void update() {
        fileHandler.saveToFile(AppConstant.USER_FILE_PATH, users);
        System.out.println("User list update");
    }
}
