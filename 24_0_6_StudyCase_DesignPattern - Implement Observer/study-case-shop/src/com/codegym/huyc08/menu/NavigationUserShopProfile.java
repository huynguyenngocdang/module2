package com.codegym.huyc08.menu;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.service.CurrentUser;

import java.util.List;
import java.util.Scanner;

public class NavigationUserShopProfile implements Command {
    private CurrentUser currentUser;
    private List<NormalUser> users;
    Menu menuUserShop = new MenuMain("User profile");
    private final Scanner SCANNER = new Scanner(System.in);

    public NavigationUserShopProfile(CurrentUser currentUser, List<NormalUser> users) {
        this.currentUser = currentUser;
        this.users = users;
    }

    public void navigationUserShopProfileMenu() {

    }
    @Override
    public void execute() {

    }
}
