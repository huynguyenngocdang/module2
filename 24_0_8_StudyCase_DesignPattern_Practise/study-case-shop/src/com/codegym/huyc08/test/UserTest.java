package com.codegym.huyc08.test;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.entity.UserFactory;
import com.codegym.huyc08.service.JsonFileHandler;
import com.codegym.huyc08.service.MyFileHandler;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.codegym.huyc08.entity.UserType.ADMIN;
import static com.codegym.huyc08.entity.UserType.NORMAL;

public class UserTest {
    public static void main(String[] args) {
        MyFileHandler fileHandler = new JsonFileHandler();

        // Save Users to a JSON file
        ArrayList<User> users = new ArrayList<>();
        ArrayList<User> admins = new ArrayList<>();
        UserFactory userFactory = new UserFactory();
        User admin = userFactory.createUser(-1,"admin_01","123",10_000, ADMIN, true);
        User normalUser1 = userFactory.createUser(1,"Huy", "123", 10_000, NORMAL, true);
        User normalUser2 = userFactory.createUser(2,"Giang", "123", 10_000, NORMAL, true);
        User normalUser3 = userFactory.createUser(3,"Son", "123", 10_000, NORMAL, true);
        admins.add(admin);
        users.add(normalUser1);
        users.add(normalUser2);

        fileHandler.saveToFile(Constants.USER_FILE_PATH,  users);
        fileHandler.saveToFile(Constants.ADMIN_FILE_PATH,  admins);

        Type adminType = new TypeToken<ArrayList<Admin>>(){}.getType();
        Type userType = new TypeToken<ArrayList<NormalUser>>(){}.getType();

        List<Admin> adminsRead = (ArrayList<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, adminType);
        List<NormalUser> userListRead = (ArrayList<NormalUser>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);

        for (Admin adminUser: adminsRead) {
            System.out.println(adminUser.toString());
        }

        for (NormalUser normalUser: userListRead) {
            System.out.println(normalUser.toString());
        }
    }
}
