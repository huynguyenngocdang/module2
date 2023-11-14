package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

import java.util.List;

public interface StrategySort {
    void sort(List<Product> products);
}
