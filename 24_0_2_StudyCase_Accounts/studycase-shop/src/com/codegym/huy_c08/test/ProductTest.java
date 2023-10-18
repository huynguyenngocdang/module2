package com.codegym.huy_c08.test;

import com.codegym.huy_c08.entity.Product;
import com.codegym.huy_c08.service.ProductService;

import java.util.LinkedList;

public class ProductTest {
    static LinkedList<Product> llProduct = new LinkedList<>();

    public static void main(String[] args) {
        llProduct.add(new Product(1, 1, "Iphone7", "Phone", 700,10,"Apple" ));
        llProduct.add(new Product(2, 2, "Iphone15", "Phone", 1000,10,"Apple" ));
        llProduct.add(new Product(3, 2, "Iphone7", "Phone", 1000,10,"Apple" ));
        ProductService.productFileWrite(llProduct);
        LinkedList<Product> llProductRead = ProductService.productFileRead();
        for (Product product: llProductRead
             ) {

            System.out.println(product.toString());
        }


    }

}
