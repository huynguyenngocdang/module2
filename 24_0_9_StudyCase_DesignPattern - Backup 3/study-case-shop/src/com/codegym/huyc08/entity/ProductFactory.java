package com.codegym.huyc08.entity;

public class ProductFactory {
    public Product createProduct(int productId, int sellerId, String productName, String productType, double productPrice, double productQuantity, String productManufacturer, String productDescription){
        return new Product(productId, sellerId, productName, productType, productPrice, productQuantity, productManufacturer, productDescription);
    }
}
