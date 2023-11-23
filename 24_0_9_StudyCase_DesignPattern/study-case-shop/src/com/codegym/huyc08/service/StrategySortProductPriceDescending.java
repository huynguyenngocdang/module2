package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

import java.util.List;

public class StrategySortProductPriceDescending implements StrategySort{
    @Override
    public void sort(List<Product> products) {
        products.sort((p1, p2)-> Double.compare(p2.getProductPrice(), p1.getProductPrice()));
    }
}
