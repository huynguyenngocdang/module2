package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

import java.util.List;

public class CommandUserDisplayProducts implements Command{
    private List<Product> currentUserProducts;
    private String currentUsername;

    public CommandUserDisplayProducts() {
        this.currentUserProducts = SingletonCurrentUserListProducts.getInstance().getCurrentUsersProduct();
        this.currentUsername = SingletonCurrentUser.getInstance().getCurrentUser().getUsername();
    }

    @Override
    public void execute() {
        if(currentUserProducts.isEmpty()) {
            System.out.println("User " + currentUsername + " does not own any products ");
        } else {
            System.out.println("List of user " + currentUsername + " product: ");
            for (Product product: currentUserProducts
            ) {
                System.out.println(product.toString());
            }
        }

    }
}
