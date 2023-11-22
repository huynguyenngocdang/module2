package com.codegym.huyc08.backup.chainAddToCartBackup;

import java.util.Scanner;

public class HandlerInputProductIdBk implements HandlerAddToCartBk {
    private HandlerAddToCartBk next;
    private final Scanner SCANNER;

    public HandlerInputProductIdBk(HandlerAddToCartBk next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCartBk requestAddToCartBk) {
        System.out.println("Input product id you want to purchase");
        int productId = SCANNER.nextInt();
        requestAddToCartBk.setProductId(productId);
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
