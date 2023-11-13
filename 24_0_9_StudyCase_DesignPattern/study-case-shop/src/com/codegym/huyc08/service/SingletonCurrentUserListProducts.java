package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class SingletonCurrentUserListProducts {
    private List<Product> currentUserProducts;
    private static SingletonCurrentUserListProducts instance;
    private SingletonCurrentUserListProducts() {
        currentUserProducts = new ArrayList<>();

    }
    public static SingletonCurrentUserListProducts getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentUserListProducts();
        }
        return instance;
    }
    public void generateCurrentUserProductList() {
        currentUserProducts.clear();
        for (Product product: SingletonListProduct.getInstance().getProducts()
        ) {
            if(product.getSellerId() == SingletonCurrentUser.getInstance().getCurrentUser().getUserId() ) {
                currentUserProducts.add(product);
            }
        }

    }
    public List<Product> getCurrentUsersProduct() {
        return  currentUserProducts;
    }
}
