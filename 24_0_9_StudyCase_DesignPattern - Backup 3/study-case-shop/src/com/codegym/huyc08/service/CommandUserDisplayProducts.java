package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

import java.util.List;

public class CommandUserDisplayProducts implements Command{

    @Override
    public void execute() {

    SingletonCurrentUserListProducts.getInstance().displayUserProduct();

    }
}
