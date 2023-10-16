package com.codegym.HuyC08.Service;

import com.codegym.HuyC08.Entity.User;
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
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void userFileWrite(LinkedList<User> llUser) {
        try {
            FileWriter writer = new FileWriter("user.json");
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
            FileReader reader = new FileReader("user.json");
            Type typeUser = new TypeToken<LinkedList<User>>(){}.getType();
            LinkedList<User> llUsersRead = gson.fromJson(reader, typeUser);
            return llUsersRead;
        } catch (FileNotFoundException fnf) {
            System.out.println("Can't find file to read");
            System.out.println(fnf.getMessage());
        }
        return null;
     }
}
