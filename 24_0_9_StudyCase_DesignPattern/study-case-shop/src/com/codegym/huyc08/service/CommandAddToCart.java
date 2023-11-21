package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainAddToCart.HandlerAddToCartFinalize;
import com.codegym.huyc08.service.chainAddToCart.HandlerInputProductId;
import com.codegym.huyc08.service.chainAddToCart.HandlerInputProductQuantity;
import com.codegym.huyc08.service.chainAddToCart.HandlerValidateProductExist;
import com.codegym.huyc08.service.chainAddToCart.HandlerValidateProductIdBelongToUser;
import com.codegym.huyc08.service.chainAddToCart.HandlerValidateProductQuantityEnough;
import com.codegym.huyc08.service.chainAddToCart.RequestToAddToCart;

import java.util.Scanner;

public class CommandAddToCart implements Command{
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {

        //input + validate product id - input + validate product amount;

        HandlerAddToCart addToCart = new HandlerAddToCartFinalize(null);
        HandlerAddToCart validateQuantity = new HandlerValidateProductQuantityEnough(addToCart);
        HandlerAddToCart inputQuantity = new HandlerInputProductQuantity(validateQuantity);
        HandlerAddToCart validateProductBelongUser = new HandlerValidateProductIdBelongToUser(inputQuantity);
        HandlerAddToCart validateProductExist = new HandlerValidateProductExist(validateProductBelongUser);
        HandlerAddToCart inputProductId = new HandlerInputProductId(validateProductExist);
        RequestAddToCart requestAddToCart = new RequestToAddToCart();
        inputProductId.handle(requestAddToCart);
    }
}
