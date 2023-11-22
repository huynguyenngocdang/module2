package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.SingletonShoppingCart;

public class HandlerAddToCartFinalize implements HandlerAddToCart {
    private HandlerAddToCart next;

    public HandlerAddToCartFinalize(HandlerAddToCart next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        Product thisProduct = requestAddToCart.getProduct();
        CartItem cartItem = new CartItem(thisProduct, requestAddToCart.getQuantity());
        SingletonShoppingCart.getInstance().addToCart(cartItem);
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
