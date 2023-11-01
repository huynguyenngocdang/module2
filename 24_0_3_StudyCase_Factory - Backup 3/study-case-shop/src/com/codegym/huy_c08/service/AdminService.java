package com.codegym.huy_c08.service;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.Admin;
import com.codegym.huy_c08.entity.NormalUser;
import com.codegym.huy_c08.entity.User;
import com.codegym.huy_c08.entity.UserFactory;
import com.codegym.huy_c08.menu.MenuConsole;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codegym.huy_c08.entity.UserType.ADMIN;

public class AdminService implements UserServiceInterface {
    private ArrayList<Admin> admins;
    private ArrayList<User> users;
    private User currentAdmin;
    private User selectedUser;
    private final MyFileHandler fileHandler = new MyFileHandler();
    private final Type adminType = new TypeToken<ArrayList<Admin>>(){}.getType();
    private final Type userType = new TypeToken<ArrayList<NormalUser>>() {}.getType();
    private final UserFactory userFactory = new UserFactory();
    private final MenuConsole menuConsole = new MenuConsole();

    public AdminService() {

        this.admins = (ArrayList<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, adminType);

        this.users = (ArrayList<User>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
    }

    public boolean isLikeAdmin(String username) {
        Pattern pattern = Pattern.compile(Constants.ADMIN_REGEX);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    @Override
    public void logIn(String username, String password) {
        if (isUserExist(username)) {
            if (isUserLoginCorrect(username, password)) {
                System.out.println("Login in");
                currentAdmin = userLogin(username, password);
            } else {
                System.out.println("Wrong password");
            }
        } else {
            System.out.println("Admin does not exist in database");
        }
    }
    @Override
    public boolean isUserExist(String username) {
        for (User admin : admins) {
            if (admin.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public boolean isUserExist(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isUserLoginCorrect(String username, String password) {
        for (User admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User userLogin(String username, String password) {
        for (User user : admins) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user ;
            }
        }
        return null;
    }

    @Override
    public void userCreate(String username, String password) {
        int newId = getNewId();
        User newAdmin = userFactory.createUser(newId, username, password, 0, ADMIN, true);
        admins.add((Admin) newAdmin);
        fileHandler.saveToFile(Constants.ADMIN_FILE_PATH, admins);
        refresh();
    }

    public void refresh(){
        admins = (ArrayList<Admin>) fileHandler.readFromFile(Constants.ADMIN_FILE_PATH, adminType);
        users = (ArrayList<User>)  fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
    }
    private int getNewId() {
        return - (admins.size() + 1);
    }

    @Override
    public void getCurrentUserInformation() {
        menuConsole.printCurrentUserInformationHeader();
        System.out.println(currentAdmin.toString());
    }

    public void getAllUserAndAdminInformation(){

        System.out.println("All admin");
        for (User admin: admins
        ) {
            System.out.println(admin.toString());
        }
        System.out.println("All user");
        for (User user: users
             ) {
            System.out.println(user.toString());
        }
    }

    public void getSelectedUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId ) {
                selectedUser = user;
            }
        }
    }

    public void getSelectedUserStatus() {
        System.out.println(selectedUser.isActive() ? "Active" : "Inactive");
    }
    public void changeSelectedUserName(String newUsername){
        selectedUser.setUsername(newUsername);
    }
    public void changeSelectedUserPassword(String newUserPassword){
        selectedUser.changePassword(newUserPassword);
    }

    public void changeSelectedUserStatus(){
        selectedUser.setActive(!selectedUser.isActive());
    }
    public void removeSelectedUser(){
        users.remove(selectedUser);
    }
    public void updateUsers() {
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
    }
}
