package com.codegym.huyc08.backup;

import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandSearchProduct;

import java.util.Scanner;

public class CommandAddToCartBk implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {

        //input + validate product id - input + validate product amount;

//        HandlerAddToCart addToCart = new HandlerAddToCartFinalize(null);
//        HandlerAddToCart validateQuantity = new HandlerValidateProductQuantityEnough(addToCart);
//        HandlerAddToCart inputQuantity = new HandlerInputProductQuantity(validateQuantity);
//        HandlerAddToCart validateProductBelongUser = new HandlerValidateProductIdBelongToUser(inputQuantity);
//        HandlerAddToCart validateProductExist = new HandlerValidateProductExist(validateProductBelongUser);
//        HandlerAddToCart inputProductId = new HandlerInputProductId(validateProductExist);
//        RequestAddToCart requestAddToCart = new RequestToAddToCart();
//        inputProductId.handle(requestAddToCart);

        Command commandSearchProduct = new CommandSearchProduct();
        commandSearchProduct.execute();
    }
}
