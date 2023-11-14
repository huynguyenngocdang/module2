package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class SingletonCurrentUserListProducts implements Observer {
    private List<Product> currentUserProducts;
    private static SingletonCurrentUserListProducts instance;
    private SingletonCurrentUserListProducts() {
        currentUserProducts = new ArrayList<>();
        generateCurrentUserProductList();
    }
    public static SingletonCurrentUserListProducts getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentUserListProducts();
        }
        return instance;
    }
    private void generateCurrentUserProductList() {
        try {
            currentUserProducts.clear();
            for (Product product: SingletonListProduct.getInstance().getProducts()
            ) {
                if(product.getSellerId() == SingletonCurrentUser.getInstance().getCurrentUser().getUserId() ) {
                    currentUserProducts.add(product);
                }
            }
        } catch (NullPointerException e) {
            for (Product product: SingletonListProduct.getInstance().getProducts()
            ) {
                if(product.getSellerId() == SingletonCurrentUser.getInstance().getCurrentUser().getUserId() ) {
                    currentUserProducts.add(product);
                }
            }
        }


    }
    public List<Product> getCurrentUsersProduct() {
        return  currentUserProducts;
    }
    public void displayUserProduct(){
        if(currentUserProducts.isEmpty()) {
            System.out.println("You don't have any product to show");
        } else {
            for (int i = 0; i < currentUserProducts.size(); i++) {
                System.out.println((i+1) + ". " + currentUserProducts.get(i).toString());
            }
        }

    }

    public void removeUserProduct(int choice) {
            Product thisProduct = currentUserProducts.remove(choice);
            SingletonListProduct.getInstance().getProducts().remove(thisProduct);

    }


    @Override
    public void update() {
        generateCurrentUserProductList();
    }
}
