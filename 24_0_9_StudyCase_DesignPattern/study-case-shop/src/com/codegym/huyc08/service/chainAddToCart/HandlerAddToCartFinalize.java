package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonShoppingCart;

public class HandlerAddToCartFinalize implements HandlerAddToCart {
    private HandlerAddToCart next;

    public HandlerAddToCartFinalize(HandlerAddToCart next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        Product thisProduct = SingletonListProduct.getInstance().getProduct(requestAddToCart.getProductId());
//        SingletonShoppingCart.getInstance().addToCart(thisProduct, requestAddToCart.getProductQuantity());
        CartItem cartItem = new CartItem(thisProduct, requestAddToCart.getProductQuantity());
        SingletonShoppingCart.getInstance().addToCart(cartItem);
        System.out.println("Product added to cart successful");
        return true;
    }

    @Override
    public void handle(RequestAddToCart requestAddToCart) {
        if(!doHandle(requestAddToCart)) {
            return;
        }
        if(next != null) {
            next.handle(requestAddToCart);
        }
    }
}
