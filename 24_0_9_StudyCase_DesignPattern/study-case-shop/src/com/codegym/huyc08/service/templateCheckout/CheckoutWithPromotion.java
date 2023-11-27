package com.codegym.huyc08.service.templateCheckout;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.entity.Promotion;
import com.codegym.huyc08.entity.PurchaseOrder;
import com.codegym.huyc08.entity.PurchaseOrderFactory;
import com.codegym.huyc08.service.GenerateId;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonListPurchaseOrder;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorUserHasEnoughCashWithPromotion;

public class CheckoutWithPromotion  extends  TemplateCheckout{
    private String promotionCode;
    private Promotion currentPromotion;
    private double promotionAmount;
    private double promotionPercent;


    public CheckoutWithPromotion(String promotionCode) {
        this.promotionCode = promotionCode;
        SingletonCurrentPromotion.getInstance().setCurrentPromotion(promotionCode);
        this.currentPromotion = SingletonCurrentPromotion.getInstance().getCurrentPromotion();
        this.promotionAmount = this.currentPromotion.getPromotionAmount();
        this.promotionPercent = this.currentPromotion.getPromotionPercent() * AppConstant.PERCENT;
    }

    @Override
    protected boolean validateCash() {
        Validator validateUserEnoughCash = new ValidatorUserHasEnoughCashWithPromotion();
        return validateUserEnoughCash.isCheck();

    }

    @Override
    protected boolean validateAddress() {
        try {
            String address = SingletonCurrentUser.getInstance().getCurrentUser().getAddress();
            if(address.isBlank()) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    protected void updateProduct(CartItem currentCartLine) {
        Product thisProduct = SingletonListProduct.getInstance().getProduct(currentCartLine.getProduct().getProductId());
        thisProduct.setProductQuantity(thisProduct.getProductQuantity() - currentCartLine.getQuantity());
    }

    @Override
    protected void updateSeller(CartItem currentCartLine, double cost) {
        NormalUser seller = SingletonListNormalUser.getInstance().getCurrentUser(currentCartLine.getProduct().getSellerId());
        double productTotalPrice = getProductTotalPriceWithPromotion(cost);
        seller.setWalletBalance(seller.getWalletBalance() + productTotalPrice);
    }



    @Override
    protected void updateBuyer(CartItem currentCartLine, double cost) {
        NormalUser buyer = SingletonCurrentUser.getInstance().getCurrentUser();
        double productTotalPrice = getProductTotalPriceWithPromotion(cost);
        buyer.setWalletBalance(buyer.getWalletBalance() - productTotalPrice);
    }

    @Override
    protected PurchaseOrder createPurchaseOrder(CartItem currentCartLine, double cost) {
        GenerateId generateId = SingletonListPurchaseOrder.getInstance();
        PurchaseOrderFactory factory = new PurchaseOrderFactory();
        int newPOId = generateId.getNewId();
        int userId = SingletonCurrentUser.getInstance().getCurrentUser().getUserId();
        int sellerId = currentCartLine.getProduct().getSellerId();
        int productId = currentCartLine.getProduct().getProductId();
        double productPrice = currentCartLine.getProduct().getProductPrice();
        double productQuantity = currentCartLine.getQuantity();
        double productTotalPriceOrigin = cost;
        double productTotalPrice = getProductTotalPriceWithPromotion(cost);
        PurchaseOrder newPO = factory.createNewPO(newPOId, userId, sellerId, productId, productPrice, productQuantity, productTotalPriceOrigin, productTotalPrice, promotionCode, promotionAmount, promotionPercent);
        return newPO;
    }

    private double getProductTotalPriceWithPromotion(double cost) {
        double productTotalPrice = cost * (1 - promotionPercent) - promotionAmount;
        if(productTotalPrice < 0) {
            return 0;
        } else {
            return productTotalPrice;
        }
    }
}
