package com.codegym.huyc08.backup.chainAddToCartBackup;

import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonShoppingCart;

import java.util.Scanner;

public class HandlerInputProductQuantityBk implements HandlerAddToCartBk {
    private HandlerAddToCartBk next;
    private final Scanner SCANNER;

    public HandlerInputProductQuantityBk(HandlerAddToCartBk next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCartBk requestAddToCartBk) {
        try {
            double currentCartItemQuantity = SingletonShoppingCart.getInstance().getCartItem(requestAddToCartBk.getProductId()).getQuantity();
            double productCurrentQuantity = SingletonListProduct.getInstance().getProduct(requestAddToCartBk.getProductId()).getProductQuantity();
            double currentAvailable = productCurrentQuantity - currentCartItemQuantity;

            System.out.println("Current available " + currentAvailable );
            System.out.println("Input product quantity you want to purchase");
            double productQuantity = SCANNER.nextInt();
            requestAddToCartBk.setProductQuantity(productQuantity);
            return true;
        } catch (NullPointerException e) {
            double productCurrentQuantity = SingletonListProduct.getInstance().getProduct(requestAddToCartBk.getProductId()).getProductQuantity();
            System.out.println("Current available " + productCurrentQuantity );
            System.out.println("Input product quantity you want to purchase");
            double productQuantity = SCANNER.nextInt();
            requestAddToCartBk.setProductQuantity(productQuantity);
            return true;
        }
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
