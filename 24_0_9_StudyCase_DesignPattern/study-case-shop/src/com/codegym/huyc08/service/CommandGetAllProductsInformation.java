package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

import java.util.List;

public class CommandGetAllProductsInformation implements Command{
    private List<Product> productList;

    public CommandGetAllProductsInformation() {
        this.productList = SingletonListProduct.getInstance().getProducts();
    }

    @Override
    public void execute() {
        for (Product product: productList
             ) {
            System.out.println(product.toString());
        }
    }
}
