package com.codegym.HuyC08.Service;

import com.codegym.HuyC08.Entity.User;

import java.util.LinkedList;

public class UserTest {
    public static void main(String[] args) {
        LinkedList<User> llUser = new LinkedList<>();
        llUser.add(new User(1,"Amin", "123", true, true, true));
        llUser.add(new User(2,"Huy", "123"));
        UserService.userFileWrite(llUser);
        LinkedList<User> llUserRead = UserService.userFileRead();
        for (User user:llUserRead
             ) {
            System.out.println(user.toString());
        }
    }
}
