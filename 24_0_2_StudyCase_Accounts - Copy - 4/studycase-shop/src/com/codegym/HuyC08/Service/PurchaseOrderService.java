package com.codegym.HuyC08.Service;

import com.codegym.HuyC08.Entity.PurchaseOrder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class PurchaseOrderService {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static LinkedList<PurchaseOrder> llPurchaseOrders = purchaseOrderRead();
    public static LinkedList<PurchaseOrder> llPurchaseOrdersCurrentUser;
    public static void purchaseOrderWrite(LinkedList<PurchaseOrder> purchaseOrders) {
        try {
            FileWriter writer = new FileWriter("data/purchaseOrder.json");
            gson.toJson(purchaseOrders, writer);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Can't write file");
            System.out.println(ioe.getMessage());
        }
    }
    public static LinkedList<PurchaseOrder> purchaseOrderRead() {
        try {
            FileReader reader = new FileReader("data/purchaseOrder.json");
            Type typePo = new TypeToken<LinkedList<PurchaseOrder>>(){}.getType();
            LinkedList<PurchaseOrder> llPurchaseOrdersRead = gson.fromJson(reader, typePo);
            return llPurchaseOrdersRead;
        } catch (FileNotFoundException fnf) {
            System.out.println("Can't find file to read");
            System.out.println(fnf.getMessage());
        }
        return null;
    }
    public static int getNewPOId() {
        int max = 0;
        for (PurchaseOrder po: llPurchaseOrders
             ) {
            if (max < po.getOrderId()) {
                max = po.getOrderId();
            }
        }
        return (max + 1);
    }

}
