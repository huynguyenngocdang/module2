package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.menu.MenuUserShopProductChange;
import com.codegym.huyc08.menu.Navigator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommandChangeUserSelectProduct implements Command{
    private Scanner SCANNER;
    private List<Product> userProducts;

    public CommandChangeUserSelectProduct() {
        this.userProducts = SingletonCurrentUserListProducts.getInstance().getCurrentUsersProduct();
    }

    @Override
    public void execute() {
        try {
            SCANNER = new Scanner(System.in);
            for (int i = 0; i < userProducts.size(); i++) {
                System.out.println((i+1) + ". " + userProducts.get(i).toString());
            }
            System.out.println("Input your product line you want to change");
            int choice = SCANNER.nextInt() - 1;
            Product thisProduct = userProducts.get(choice);
            SingletonCurrentUserProduct.getInstance().setCurrentUserProduct(thisProduct);
            Navigator navigator = new MenuUserShopProductChange();
            navigator.navigate();
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Invalid choice, please try again");
        }
    }
}
