package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class CommandGetAllUsersInformation implements Command {
    @Override
    public void execute() {
        System.out.println("All user information");
        SingletonListNormalUser.getInstance().displayAllUsers();
        System.out.println("-------------------");
        System.out.println("All admin information");
        SingletonListAdmin.getInstance().displayAllAdminInfo();
    }
}
