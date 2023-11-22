package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.service.RequestAddToCart;

public class RequestToAddToCart implements RequestAddToCart {
    private Product product;
    private double quantity;

    public RequestToAddToCart(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void setProduct(Product product) {
        this.product = product;
    }
}
