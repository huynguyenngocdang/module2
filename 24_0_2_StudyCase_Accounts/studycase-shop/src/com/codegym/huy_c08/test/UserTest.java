package com.codegym.huy_c08.test;

import com.codegym.huy_c08.entity.User;
import com.codegym.huy_c08.service.UserService;

import java.util.LinkedList;

public class UserTest {
    public static void main(String[] args) {
        LinkedList<User> llUser = new LinkedList<>();
        llUser.add(new User(1,"Admin", "123","admin", 1000000.00, true, true, true));
        llUser.add(new User(2,"Huy", "123"));
        UserService.userFileWrite(llUser);
        LinkedList<User> llUserRead = UserService.userFileRead();
        for (User user:llUserRead
        ) {
            System.out.println(user.toString());
        }
    }
}
