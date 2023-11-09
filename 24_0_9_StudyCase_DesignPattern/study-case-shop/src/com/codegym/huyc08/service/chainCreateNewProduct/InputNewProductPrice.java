package com.codegym.huyc08.service.chainCreateNewProduct;

import com.codegym.huyc08.service.HandlerNewProduct;
import com.codegym.huyc08.service.RequestNewProduct;

import java.util.Scanner;

public class InputNewProductPrice implements HandlerNewProduct {
    private HandlerNewProduct next;
    private final Scanner SCANNER;

    public InputNewProductPrice(HandlerNewProduct next) {
        this.next = next;
        this.SCANNER = new Scanner(System.in);
    }

    @Override
    public boolean doHandle(RequestNewProduct requestNewProduct) {
        System.out.println("Input your new product price");
        double newProductPrice = SCANNER.nextDouble();
        requestNewProduct.setProductPrice(newProductPrice);
        return true;
    }

    @Override
    public void handle(RequestNewProduct requestNewProduct) {
        if(!doHandle(requestNewProduct)) {
            return;
        }
        if(next != null) {
            next.handle(requestNewProduct);
        }
    }
}
