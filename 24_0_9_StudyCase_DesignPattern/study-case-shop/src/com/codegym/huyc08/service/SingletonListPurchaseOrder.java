package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.PurchaseOrder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingletonListPurchaseOrder implements Observer, GenerateId{
    private List<PurchaseOrder> purchaseOrders;
    private final MyFileHandler fileHandler;
    private final Type PO_TYPE = new TypeToken<ArrayList<PurchaseOrder>>(){}.getType();
    private SingletonListPurchaseOrder() {
        fileHandler = new JsonFileHandler();
        purchaseOrders = (List<PurchaseOrder>) fileHandler.readFromFile(Constants.PURCHASE_ORDER_FILE_PATH, PO_TYPE);
        if (purchaseOrders == null) {
            purchaseOrders = new ArrayList<>();
        }
    }
    private static SingletonListPurchaseOrder instance;
    public static SingletonListPurchaseOrder getInstance() {
        if(instance == null) {
            instance = new SingletonListPurchaseOrder();
        }
        return instance;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrders.add(purchaseOrder);
    }

    @Override
    public void update() {
        fileHandler.saveToFile(Constants.PURCHASE_ORDER_FILE_PATH, purchaseOrders);
        System.out.println("Purchase order database update successfully");
    }

    @Override
    public int getNewId() {
        try {
            int max = 0;
            for (PurchaseOrder po: purchaseOrders
            ) {
                if(max < po.getPurchaseOrderId()) {
                    max = po.getPurchaseOrderId();
                }
            }
            return max +1;
        } catch (NullPointerException e) {
            return 1;
        }

    }
}
