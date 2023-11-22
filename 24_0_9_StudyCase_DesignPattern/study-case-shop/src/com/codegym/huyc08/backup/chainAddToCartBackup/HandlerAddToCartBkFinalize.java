package com.codegym.huyc08.backup.chainAddToCartBackup;

import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonShoppingCart;

public class HandlerAddToCartBkFinalize implements HandlerAddToCartBk {
    private HandlerAddToCartBk next;

    public HandlerAddToCartBkFinalize(HandlerAddToCartBk next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCartBk requestAddToCartBk) {
        Product thisProduct = SingletonListProduct.getInstance().getProduct(requestAddToCartBk.getProductId());
//        SingletonShoppingCart.getInstance().addToCart(thisProduct, requestAddToCart.getProductQuantity());
        CartItem cartItem = new CartItem(thisProduct, requestAddToCartBk.getProductQuantity());
        SingletonShoppingCart.getInstance().addToCart(cartItem);
        System.out.println("Product added to cart successful");
        return true;
    }

    @Override
    public void handle(RequestAddToCartBk requestAddToCartBk) {
        if(!doHandle(requestAddToCartBk)) {
            return;
        }
        if(next != null) {
            next.handle(requestAddToCartBk);
        }
    }
}
