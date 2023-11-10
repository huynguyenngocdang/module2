package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.RequestNewProduct;

import java.util.Scanner;

public class HandlerInputProductId implements HandlerAddToCart {
    private HandlerAddToCart next;
    private final Scanner SCANNER;

    public HandlerInputProductId(HandlerAddToCart next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        System.out.println("Input product id you want to purchase");
        int productId = SCANNER.nextInt();
        requestAddToCart.setProductId(productId);
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
