package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class SingletonCurrentUserListProducts {
    private NormalUser currentUser;
    private List<Product> currentUserProducts;
    private static SingletonCurrentUserListProducts instance;
    private SingletonCurrentUserListProducts() {
        currentUser = SingletonCurrentUser.getInstance().getCurrentUser();
        currentUserProducts = new ArrayList<>();
    }
    public static SingletonCurrentUserListProducts getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentUserListProducts();
        }
        return instance;
    }
    public void generateCurrentUserProductList() {
        for (Product product: SingletonListProduct.getInstance().getProducts()
        ) {
            if(product.getSellerId() == currentUser.getUserId() ) {
                currentUserProducts.add(product);
            }
        }
    }
    public List<Product> getCurrentUsersProduct() {
        return  currentUserProducts;
    }
}
