package com.codegym.huyc08.entity;

public class PurchaseOrderFactory {
    public PurchaseOrder createNewPO(int purchaseOrderId,int userId, int sellerId, int productId, double productPrice, double productQuantity, double productTotalPrice) {
        return new PurchaseOrder(purchaseOrderId, userId, sellerId, productId, productPrice, productQuantity, productTotalPrice);
    }
    public PurchaseOrder createNewPO(int purchaseOrderId,int userId, int sellerId,int productId,double productPrice,double productQuantity,double productTotalPriceOrigin,double productTotalPrice,String promotionName, double promotionAmount,double promotionPercent) {
        return new PurchaseOrder(purchaseOrderId, userId, sellerId,productId, productPrice, productQuantity, productTotalPriceOrigin, productTotalPrice, promotionName,promotionAmount,promotionPercent);
    }
}
