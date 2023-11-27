package com.codegym.huyc08.validator;

import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.service.SingletonListProduct;

import java.util.List;

public class ValidatorProductBelongToUser implements Validator{
    private int productId;
    private List<Product> products;
    private int sellerId;

    public ValidatorProductBelongToUser(int productId, int sellerId) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.products = SingletonListProduct.getInstance().getProducts();
    }

    @Override
    public boolean isCheck() {
        for (Product product: products
             ) {
            if(product.getProductId() == productId && product.getSellerId() == sellerId) {
                return true;
            }
        }
        return false;
    }
}
