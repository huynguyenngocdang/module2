package com.codegym.huy_c08.service;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.PurchaseOrder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PurchaseOrderService {
    private ArrayList<PurchaseOrder> purchaseOrders;
    private final MyFileHandler fileHandler = new MyFileHandler();
    private final Type purchaseOrderType = new TypeToken<ArrayList<PurchaseOrder>>(){}.getType();

    public PurchaseOrderService() {
        this.purchaseOrders = (ArrayList<PurchaseOrder>) fileHandler.readFromFile(Constants.PURCHASE_ORDER_FILE_PATH, purchaseOrderType);
    }
    public int getNewId() {
        int max = 0;
        for (PurchaseOrder po: purchaseOrders
             ) {
            if(max < po.getPurchaseOrderId()) {
                max = po.getPurchaseOrderId();
            }
        }
        return max + 1;
    }
    public void addPurchaseOrder(PurchaseOrder purchaseOrder){
        purchaseOrders.add(purchaseOrder);
        updatePurchaseOrder();
    }
    public void updatePurchaseOrder(){
        fileHandler.saveToFile(Constants.PURCHASE_ORDER_FILE_PATH, purchaseOrders);
    }
}
