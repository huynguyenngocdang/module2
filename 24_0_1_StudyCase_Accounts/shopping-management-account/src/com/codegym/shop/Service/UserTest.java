package com.codegym.shop.Service;

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

public class UserTest {
    public static void main(String[] args) {
        LinkedList<User> users = getExampleUser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("user.json");
            gson.toJson(users, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader reader = new FileReader("user.json");
            Type userType = new TypeToken<LinkedList<User>>(){}.getType();
            LinkedList<User> userRead = gson.fromJson(reader, userType);

            for (User user: userRead) {
                System.out.println(user.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static LinkedList<User> getExampleUser() {
        User admin1 = new User("Huy","123", "admin",100000000, true, true, true, true, true, true, true );
        User mod1 = new User("Son","123", "moderator",0, false, true, false, true, true, true, true );
        User normalUser1 = new User("Man","111", "normal",100000000, false, false, false, true, true, true, true );
        User anonymous1 = new User("Anonymous","111", "normal",100000000, false, false, false, false, false, false, true );
        LinkedList<User> users = new LinkedList<>();
        users.add(admin1);
        users.add(mod1);
        users.add(normalUser1);
        users.add(anonymous1);
        return users;
    }
}
