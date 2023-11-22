package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

public interface RequestAddToCart {
    Product getProduct();
    void setProduct(Product product);

     double getQuantity();

     void setQuantity(double quantity);
}
