package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.menu.MenuUserShopProductChange;
import com.codegym.huyc08.menu.Navigator;

import java.util.List;
import java.util.Scanner;

public class CommandChangeUserSelectProduct implements Command{
    private final Scanner SCANNER = new Scanner(System.in);
    private List<Product> userProducts;

    public CommandChangeUserSelectProduct() {
        this.userProducts = SingletonCurrentUserListProducts.getInstance().getCurrentUsersProduct();
    }

    @Override
    public void execute() {
        try {
            for (int i = 0; i < userProducts.size(); i++) {
                System.out.println((i+1) + ". " + userProducts.get(i).toString());
            }
            System.out.println("Input your product line you want to change");
            int choice = SCANNER.nextInt() - 1;
            Product thisProduct = userProducts.get(choice);
            SingletonCurrentUserProduct.getInstance().setCurrentUserProduct(thisProduct);
            Navigator navigator = new MenuUserShopProductChange();
            navigator.navigate();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid choice, please try again");
        }
    }
}
