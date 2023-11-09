package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainCreateNewProduct.CreateNewProduct;
import com.codegym.huyc08.service.chainCreateNewProduct.InputNewProductDescription;
import com.codegym.huyc08.service.chainCreateNewProduct.InputNewProductManufacturer;
import com.codegym.huyc08.service.chainCreateNewProduct.InputNewProductName;
import com.codegym.huyc08.service.chainCreateNewProduct.InputNewProductPrice;
import com.codegym.huyc08.service.chainCreateNewProduct.InputNewProductQuantity;
import com.codegym.huyc08.service.chainCreateNewProduct.InputNewProductType;
import com.codegym.huyc08.service.chainCreateNewProduct.RequestCreateNewProduct;
import com.codegym.huyc08.service.chainCreateNewProduct.ValidateNewProductPriceNotNegative;
import com.codegym.huyc08.service.chainCreateNewProduct.ValidateNewProductQuantityNotNegative;

public class CommandUserAddNewProduct implements Command{

    @Override
    public void execute() {
        //name - type - price + val price - quantity + val quantity - manufacturer - description - create
        HandlerNewProduct createNewProduct = new CreateNewProduct(null);
        HandlerNewProduct inputDescription = new InputNewProductDescription(createNewProduct);
        HandlerNewProduct inputManufacturer = new InputNewProductManufacturer(inputDescription);
        HandlerNewProduct validateQuantity = new ValidateNewProductQuantityNotNegative(inputManufacturer);
        HandlerNewProduct inputQuantity = new InputNewProductQuantity(validateQuantity);
        HandlerNewProduct validatePrice = new ValidateNewProductPriceNotNegative(inputQuantity);
        HandlerNewProduct inputPrice = new InputNewProductPrice(validatePrice);
        HandlerNewProduct inputType = new InputNewProductType(inputPrice);
        HandlerNewProduct inputName = new InputNewProductName(inputType);
        inputName.handle(new RequestCreateNewProduct());
    }
}
