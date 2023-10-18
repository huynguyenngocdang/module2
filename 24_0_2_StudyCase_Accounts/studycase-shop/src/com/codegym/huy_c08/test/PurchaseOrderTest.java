package com.codegym.huy_c08.test;

import com.codegym.huy_c08.entity.PurchaseOrder;
import com.codegym.huy_c08.service.PurchaseOrderService;

import java.util.LinkedList;

public class PurchaseOrderTest {
    static LinkedList<PurchaseOrder> llPurchaseOrders = new LinkedList<>();
    public static void main(String[] args) {
        llPurchaseOrders.add(new PurchaseOrder(1, 3,2,1, 700, 2));
        llPurchaseOrders.add(new PurchaseOrder(2, 3,2,1, 700, 3));
        PurchaseOrderService.purchaseOrderWrite(llPurchaseOrders);
        LinkedList<PurchaseOrder> llPurchaseOrderRead = PurchaseOrderService.purchaseOrderRead();
        for (PurchaseOrder po: llPurchaseOrderRead
             ) {
            System.out.println(po.toString());
        }
    }
}
