package com.codegym.huyc08.service.chainCreateNewProduct;

import com.codegym.huyc08.service.HandlerNewProduct;
import com.codegym.huyc08.service.RequestNewProduct;

import java.util.Scanner;

public class InputNewProductDescription implements HandlerNewProduct {
    private HandlerNewProduct next;
    private final Scanner SCANNER;

    public InputNewProductDescription(HandlerNewProduct next) {
        this.next = next;
        this.SCANNER = new Scanner(System.in);
    }

    @Override
    public boolean doHandle(RequestNewProduct requestNewProduct) {
        System.out.println("Input your new product description");
        String newProductDescription = SCANNER.nextLine();
        requestNewProduct.setProductDescription(newProductDescription);
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
