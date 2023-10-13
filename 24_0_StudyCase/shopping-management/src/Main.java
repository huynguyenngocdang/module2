import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input username");
        String username = scanner.next();
        System.out.println("Input password");
        String password = scanner.next();
//        User currUser = new User(username, password);
//        User user1 = new User("Huy", "123");
//        User user2 = new User("Hau", "234");
//        LinkedList<User> users = new LinkedList<>();
//        users.add(currUser);
//        users.add(user1);
//        users.add(user2);
        boolean isUserFound = false;
        boolean isCorrectPassword = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        try {
//            FileWriter writer = new FileWriter("user.json");
//            gson.toJson(users, writer);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            FileReader reader = new FileReader("user.json");
            Type userType = new TypeToken<LinkedList<User>>(){}.getType();
            LinkedList<User> users = gson.fromJson(reader, userType);

            for (User user: users) {
                if (user.getUsername().equals(username) ) {
                    isUserFound = true;
                    break;
                }
            }

            for (User user: users) {
                if(user.getUserPassword().equals(password) ) {
                    isCorrectPassword = true;
                    break;
                }
            }
            if (isUserFound && isCorrectPassword) {
                System.out.println("Log in");
            } else if (isUserFound) {
                System.out.println("Incorrect password");
            } else {
                System.out.println("User not found");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}