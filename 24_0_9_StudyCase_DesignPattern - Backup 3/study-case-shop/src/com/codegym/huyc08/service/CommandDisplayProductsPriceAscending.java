package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

import java.util.List;

public class CommandDisplayProductsPriceAscending implements Command{
    private StrategySort strategySort;
    private List<Product> products;

    public CommandDisplayProductsPriceAscending() {
        this.strategySort = new ProductPriceAscendingSort();
        this.products = SingletonListProduct.getInstance().getProducts();
    }

    @Override
    public void execute() {
        strategySort.sort(products);
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ". " + products.get(i).toString());
        }
    }
}
