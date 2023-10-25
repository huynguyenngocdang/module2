package com.codegym.huy_c08.entity;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> productsCart;

    public ShoppingCart() {
        this.productsCart = new ArrayList<>();
    }
    public void addToCart(Product product) {
        productsCart.add(product);
    }
    public void showCart() {
        for (Product product: productsCart
             ) {
            System.out.println(product.toString());
        }
    }

}
