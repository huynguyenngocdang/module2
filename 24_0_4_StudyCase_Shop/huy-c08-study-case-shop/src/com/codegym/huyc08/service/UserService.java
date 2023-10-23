package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private ArrayList<?> userList;
    private User currentUser;
    private final Type userType = new TypeToken<ArrayList<User>>(){}.getType();
    private final MyFileHandler fileHandler = new MyFileHandler();

    public UserService() {
        this.userList = fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
    }
}
