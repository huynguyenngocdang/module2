package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

public class SingletonCurrentUserProduct {
    private Product currentUserProduct;
    private static SingletonCurrentUserProduct instance;
    private SingletonCurrentUserProduct() {

    }
    public static SingletonCurrentUserProduct getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentUserProduct();
        }
        return instance;
    }
    public void setCurrentUserProduct(Product currentUserProduct) {
        this.currentUserProduct = currentUserProduct;
    }

    public Product getCurrentUserProduct() {
        return currentUserProduct;
    }
}
