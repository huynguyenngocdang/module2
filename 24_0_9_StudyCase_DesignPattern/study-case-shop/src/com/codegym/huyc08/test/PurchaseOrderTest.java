package com.codegym.huyc08.test;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.PurchaseOrder;
import com.codegym.huyc08.entity.PurchaseOrderFactory;
import com.codegym.huyc08.service.JsonFileHandler;
import com.codegym.huyc08.service.MyFileHandler;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PurchaseOrderTest {

    public static void main(String[] args) {
        PurchaseOrderFactory factory = new PurchaseOrderFactory();
        PurchaseOrder purchaseOrder1 = factory.createNewPO(1,1,2,2, 1000, 1, 1000);
        PurchaseOrder purchaseOrder2 = factory.createNewPO(2,1,2,2, 1000, 1, 1000, 900,"KM01",0,10);
        ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<>();
        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);

        MyFileHandler fileHandler = new JsonFileHandler();
        fileHandler.saveToFile(AppConstant.PURCHASE_ORDER_FILE_PATH, purchaseOrders);
        Type purchaseOrderType = new TypeToken<ArrayList<PurchaseOrder>>(){}.getType();
        ArrayList<PurchaseOrder> purchaseOrdersRead = (ArrayList<PurchaseOrder>) fileHandler.readFromFile(AppConstant.PURCHASE_ORDER_FILE_PATH, purchaseOrderType);

        for (PurchaseOrder po: purchaseOrdersRead
             ) {
            System.out.println(po.toString());
        }
    }
}
