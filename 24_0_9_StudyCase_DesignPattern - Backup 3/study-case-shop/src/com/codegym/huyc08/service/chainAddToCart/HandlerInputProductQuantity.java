package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonShoppingCart;

import java.util.Optional;
import java.util.Scanner;

public class HandlerInputProductQuantity implements HandlerAddToCart {
    private HandlerAddToCart next;
    private final Scanner SCANNER;

    public HandlerInputProductQuantity(HandlerAddToCart next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        try {
            double currentCartItemQuantity = SingletonShoppingCart.getInstance().getCartItem(requestAddToCart.getProductId()).getQuantity();
            double productCurrentQuantity = SingletonListProduct.getInstance().getProduct(requestAddToCart.getProductId()).getProductQuantity();
            double currentAvailable = productCurrentQuantity - currentCartItemQuantity;

            System.out.println("Current available " + currentAvailable );
            System.out.println("Input product quantity you want to purchase");
            double productQuantity = SCANNER.nextInt();
            requestAddToCart.setProductQuantity(productQuantity);
            return true;
        } catch (NullPointerException e) {
            double productCurrentQuantity = SingletonListProduct.getInstance().getProduct(requestAddToCart.getProductId()).getProductQuantity();
            System.out.println("Current available " + productCurrentQuantity );
            System.out.println("Input product quantity you want to purchase");
            double productQuantity = SCANNER.nextInt();
            requestAddToCart.setProductQuantity(productQuantity);
            return true;
        }
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
