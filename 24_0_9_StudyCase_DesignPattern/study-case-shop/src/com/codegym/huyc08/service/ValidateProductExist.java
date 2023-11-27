package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.validator.Validator;

import java.util.List;

public class ValidateProductExist implements Validator {
    private int productId;
    private List<Product> products;

    public ValidateProductExist(int productId) {
        this.productId = productId;
        products = SingletonListProduct.getInstance().getProducts();
    }

    @Override
    public boolean isCheck() {
        for (Product product: products
             ) {
            if(productId == product.getProductId()) {
                return true;
            }
        }
        return false;
    }
}
