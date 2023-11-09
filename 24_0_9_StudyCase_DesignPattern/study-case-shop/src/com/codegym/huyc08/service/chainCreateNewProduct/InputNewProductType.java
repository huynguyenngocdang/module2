package com.codegym.huyc08.service.chainCreateNewProduct;

import com.codegym.huyc08.service.HandlerNewProduct;
import com.codegym.huyc08.service.RequestNewProduct;

import java.util.Scanner;

public class InputNewProductType implements HandlerNewProduct {
    private HandlerNewProduct next;
    private final Scanner SCANNER;

    public InputNewProductType(HandlerNewProduct next) {
        this.next = next;
        this.SCANNER = new Scanner(System.in);
    }

    @Override
    public boolean doHandle(RequestNewProduct requestNewProduct) {
        System.out.println("Input your new product type");
        String newProductType = SCANNER.nextLine();
        requestNewProduct.setProductType(newProductType);
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
