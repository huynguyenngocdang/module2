package com.codegym.huyc08.test;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.entity.UserFactory;
import com.codegym.huyc08.entity.UserType;
import com.codegym.huyc08.service.MyFileHandler;

import java.util.ArrayList;
import java.util.List;

import static com.codegym.huyc08.entity.UserType.ADMIN;
import static com.codegym.huyc08.entity.UserType.NORMAL;

public class UserTest {
    public static void main(String[] args) {
        MyFileHandler fileHandler = new MyFileHandler();
        UserFactory userFactory = new UserFactory();

        List<User> usersInput = new ArrayList<>();
        User admin1 = userFactory.createUser(-1,"admin_01", "123", 10_000, ADMIN, true);
        User normalUser1 = userFactory.createUser(1, "Huy","123", 10_000, NORMAL, true);
        User normalUser2 = userFactory.createUser(2, "Giang","123", 10_000, NORMAL, true);

        usersInput.add(admin1);
        usersInput.add(normalUser1);
        usersInput.add(normalUser2);

        fileHandler.saveToFile(Constants.USER_FILE_PATH, usersInput);

    }
}
