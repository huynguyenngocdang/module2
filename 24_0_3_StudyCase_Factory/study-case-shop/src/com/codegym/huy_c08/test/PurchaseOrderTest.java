package com.codegym.huy_c08.test;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.PurchaseOrder;
import com.codegym.huy_c08.service.MyFileHandler;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PurchaseOrderTest {

    public static void main(String[] args) {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1,1,2,2, 1000, 1, 1000);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2,1,2,2, 1000, 1, 1000, 900,"KM01",0,10);
        ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<>();
        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);

        MyFileHandler fileHandler = new MyFileHandler();
        fileHandler.saveToFile(Constants.PURCHASE_ORDER_FILE_PATH, purchaseOrders);
        Type purchaseOrderType = new TypeToken<ArrayList<PurchaseOrder>>(){}.getType();
        ArrayList<PurchaseOrder> purchaseOrdersRead = (ArrayList<PurchaseOrder>) fileHandler.readFromFile(Constants.PURCHASE_ORDER_FILE_PATH, purchaseOrderType);

        for (PurchaseOrder po: purchaseOrdersRead
             ) {
            System.out.println(po.toString());
        }
    }
}
